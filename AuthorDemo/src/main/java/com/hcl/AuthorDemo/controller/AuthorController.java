package com.hcl.AuthorDemo.controller;

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

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	// Author Registration
	@GetMapping("/author")
	public String getPage(Model model) {
		model.addAttribute("formobj", new AuthorForm());
		return "registration";
	}

	@PostMapping("/author") // Spring expects BindingResult to come right after the @Valid parameter
	public String saveAuthor(@ModelAttribute("formobj") @Valid AuthorForm authorForm, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("formobj", authorForm);
			return "registration";
		}
		AuthorDto authorDto = new AuthorDto();
		BeanUtils.copyProperties(authorForm, authorDto);
		authorService.saveAuthor(authorDto);
		model.addAttribute("authors", authorService.getAllAuthors());
		return "redirect:list"; // url not view name
	}

	// Fetch all authors
	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("authors", authorService.getAllAuthors());
		return "authorlist";
	}

	// Author Login

	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("loginform", new LoginForm());
		return "login";
	}

	@PostMapping("/login") 
	public String authorLogin(@ModelAttribute("loginform") LoginForm loginForm, Model model) {
		boolean flag=authorService.loginAuthor(loginForm);
		if(flag)
			return "dashboard"; 
		System.out.println(loginForm);
		model.addAttribute("msg", "Invalid Credetails.Please try again...");
		return "login"; 
	}
}
