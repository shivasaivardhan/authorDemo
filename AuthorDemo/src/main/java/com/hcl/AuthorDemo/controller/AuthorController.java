package com.hcl.AuthorDemo.controller;

import com.hcl.AuthorDemo.service.JavaMailSenderService;
import com.hcl.AuthorDemo.service.OtpService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.AuthorDemo.dto.AuthorDto;
import com.hcl.AuthorDemo.form.AuthorForm;
import com.hcl.AuthorDemo.form.LoginForm;
import com.hcl.AuthorDemo.service.AuthorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorController {

    private static int otp_main;
    @Autowired
    private AuthorService authorService;

    @Autowired
    private OtpService otpService;

    @Autowired
    JavaMailSenderService mailSenderService;

    // Author Registration
    @GetMapping("/author")
    public String getPage(Model model) {
        model.addAttribute("formobj", new AuthorForm());
        return "registration";
    }

    @PostMapping("/author") // Spring expects BindingResult to come right after the @Valid parameter
    public String saveAuthor(@ModelAttribute("formobj") @Valid AuthorForm authorForm, BindingResult result,
                             Model model, HttpSession httpSession) throws MessagingException {
        if (result.hasErrors()) {
            model.addAttribute("formobj", authorForm);
            return "registration";
        }
        AuthorDto authorDto = new AuthorDto();
        BeanUtils.copyProperties(authorForm, authorDto);
        httpSession.setAttribute(authorDto.getEmail(), authorDto);
        otp_main = otpService.getOTP();
        otpService.saveOtp(authorDto.getEmail(), otp_main);
        mailSenderService.sendEmailHtml(authorDto.getEmail(), "OTP Verification", otp_main);
        model.addAttribute("email", authorDto.getEmail());
        //model.addAttribute("msg", otp_main);
        return "otp-verify";
    }

    //OTP Verification
    @PostMapping("/verifyotp")
    public String otpVerification(@RequestParam("otp") int otp, @RequestParam("email") String email, Model model, HttpSession httpSession) {
        if (otpService.fetchVerifyOtp(email, otp)) {
            authorService.saveAuthor((AuthorDto) httpSession.getAttribute(email));
            return "dashboard";
        }
        model.addAttribute("email", email);
        model.addAttribute("msg", "OTP verification file.Try again");
        return "otp-verify";
    }

    // Author Login
    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("loginform", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String authorLogin(@ModelAttribute("loginform") LoginForm loginForm, Model model) {
        boolean flag = authorService.loginAuthor(loginForm);
        if (flag)
            return "dashboard";
        System.out.println(loginForm);
        model.addAttribute("msg", "Invalid Credetails.Please try again...");
        return "login";
    }

    // Fetch all authors
    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authorlist";
    }

}
