package com.seindu.birthdays.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seindu.birthdays.models.Person;
import com.seindu.birthdays.services.PersonService;
import com.seindu.birthdays.services.UserService;

@Controller
@RequestMapping("/main")
public class PersonController {
	@Autowired
	private UserService uServ;
	@Autowired
	private PersonService pServ;
	
	@GetMapping("")
	public String landing(HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("persons", this.pServ.getPersons());
		viewModel.addAttribute("user", this.uServ.findUserById(userId));
		return "main.jsp";
	}
	
	@GetMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user_id", userId);
		return "create.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "create.jsp";
		}
		this.pServ.create(person);
		
		return "redirect:/main";
	}
	
	@GetMapping("/{id}")
	public String showperson(@PathVariable("id")Long id, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Person person = this.pServ.findById(id);
		if(userId == null) {
			return "redirect:/"; 
		}
		if(person == null) {
			return "redirect:/main"; 
		} 
		viewModel.addAttribute("user_id", userId);
		viewModel.addAttribute("person", person);
		return "view.jsp"; 
	}
	
	@GetMapping("/edit/{id}")
	public String updatePerson(@PathVariable("id") Long id, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		Person person = this.pServ.findById(id);
		if(userId == null) {
			return "redirect:/"; 
		}
		if(person == null || !person.getThisUser().getId().equals(userId)) {
			return "redirect:/main"; 
		}
		viewModel.addAttribute("person", person);
		viewModel.addAttribute("user_id", userId);
		return "update.jsp"; 
	}
	
	@PostMapping("edit/{id}")
	public String update(@Valid @ModelAttribute("idea") Person person, BindingResult result, @PathVariable("id")Long id, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("person", person);
			viewModel.addAttribute("user_id", userId);
			return "update.jsp"; 
			
		}
		this.pServ.updatePerson(person);
		return "redirect:/main"; 
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.pServ.deletePerson(id);
		return "redirect:/main";
		}
	
	
}
