package com.seindu.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seindu.events.models.State;
import com.seindu.events.models.User;
import com.seindu.events.services.UserService;
import com.seindu.events.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uServ;
	@Autowired
	private UserValidator uValid;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user, Model viewModel) {
		viewModel.addAttribute("states", State.States);
		return "registration.jsp";
	}
	
	@PostMapping("/")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model viewModel) {
		uValid.validate(user, result);
		if(result.hasErrors()) {
			viewModel.addAttribute("states", State.States);
			return "registration.jsp";
		}
		
		User newUser = this.uServ.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/events";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes rAttrs, HttpSession session) {
		if(!this.uServ.authenticateUser(email, password)) {
			rAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		
		User user = this.uServ.findUserByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/events";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
