package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.Repository.UsersRepository;
import com.springboot.model.Users_;
import com.springboot.service.UsersService;

import javax.validation.Valid;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("/home")
	public String home() {
		return "Users/home";
	}

	@RequestMapping("/signup")
	public String sigUp(Model model) {
		// Users_ newUser=new Users_();
		System.out.println();
		model.addAttribute("newUser", new Users_());
		return "Users/signup";
	}

	@RequestMapping("/reg")
	public String reg(@Valid @ModelAttribute("newUser") Users_ users, BindingResult result, Model model)
			throws Exception {

		Users_ existingUser = usersRepository.findByEmail(users.getEmail());
		if (existingUser != null) {
			result.rejectValue("email", "Duplicate.user.email", "Email already exists");
		}
		if (result.hasErrors()) {
			return "Users/signup";
		}

		usersService.addUser(users);
		return "redirect:/signup?success=true";

	}

	@GetMapping("/signin")
	public String sigin() {
		System.out.println("Sign in");
		return "Users/signin";
	}

	@GetMapping("/unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}

}
