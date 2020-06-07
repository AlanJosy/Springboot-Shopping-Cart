package com.shop.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.models.Customer;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@GetMapping("/login")
	public String displayLogin(Model model) {
		Customer user= new Customer();

		
		model.addAttribute("user",user);
		
		return "user_login";
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("user")Customer user,Errors errors,Model model) {
		
		if(errors.hasErrors()) {
			return "user_login";
		}
		System.out.println(user.getName()+" logged in");
		return "redirect:/";
	}
}
