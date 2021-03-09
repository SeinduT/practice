 package com.seindu.loginandreg.controllers;

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

import com.seindu.loginandreg.models.User;
import com.seindu.loginandreg.services.UserService;
import com.seindu.loginandreg.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uServ;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String login(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uServ.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	} 
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uServ.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		
		User user = this.uServ.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		User user = this.uServ.findOneUser(userId);
		viewModel.addAttribute("user", user);
		return "show.jsp";
	}
}
