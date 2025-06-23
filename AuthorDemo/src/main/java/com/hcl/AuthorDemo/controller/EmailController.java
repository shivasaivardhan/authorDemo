package com.hcl.AuthorDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.AuthorDemo.service.JavaMailSenderService;

import jakarta.mail.MessagingException;

@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private JavaMailSenderService mailSenderService;

//	@GetMapping("/send")
//	public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body,Model model) {
//		mailSenderService.sendEmail(to, subject, body);
//		model.addAttribute("message", "Email sent successfully!");
//		return "emailResult"; // This should map to emailResult.jsp
//	}
	
	@GetMapping("/send")
	public String sendEmail(Model model) {
		mailSenderService.sendEmail("shivasaivardhan127@gmail.com", "Demo mail", "hello world");
		model.addAttribute("message", "Email sent successfully!");
		return "emailResult"; // This should map to emailResult.jsp
	}
	
	@GetMapping("/sendHtml")
	public String sendEmailHtml(Model model) throws MessagingException {
		mailSenderService.sendEmailHtml("shivasaivardhan127@gmail.com", "Demo HTML mail",0);
		model.addAttribute("message", "Email sent successfully!");
		return "emailResult"; // This should map to emailResult.jsp
	}
}
