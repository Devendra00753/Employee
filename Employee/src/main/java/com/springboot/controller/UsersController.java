package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.model.Users_;
import com.springboot.service.UsersService;

import javax.validation.Valid;

@Controller
public class UsersController   {

	
	@Autowired
	private UsersService usersService;

	@GetMapping("/home")
	public String home() {
		return "Users/home";
	}
	
	
	@RequestMapping("/signup")
	public String sigUp(Model model) {
		// Users_ newUser=new Users_();
		model.addAttribute("newUser", new Users_());
		return "Users/signup";	
	}
	
	@RequestMapping("/reg")
	public String reg(@Valid @ModelAttribute("newUser") Users_ users, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Users/signup";
		}
		usersService.addUser(users);
		return "redirect:/employees";

	}


	@GetMapping("/signin")
	public String sigin() {
		return "Users/signin";
	}
	
	
}
