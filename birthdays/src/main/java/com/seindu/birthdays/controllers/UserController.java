package com.seindu.birthdays.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seindu.birthdays.models.User;
import com.seindu.birthdays.services.UserService;
import com.seindu.birthdays.validators.UserValidator;

@Controller
public class UserController {	
	@Autowired
	private UserService uServ;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "login.jsp";
		}
		User newUser = this.uServ.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/main";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uServ.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uServ.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
