package com.seindu.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seindu.license.models.License;
import com.seindu.license.models.Person;
import com.seindu.license.services.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService pService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Person> allPersons = this.pService.getAllPersons();
		viewModel.addAttribute("allPersons", allPersons);
		return "show.jsp";
	}
	
	@GetMapping("/add")
	public String addPerson(@ModelAttribute("person") Person person) {
		return "addPerson.jsp";
	}
	
	@PostMapping("/addNewPerson")
	public String addNewPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "addPerson.jsp";
		}
		this.pService.createPerson(person);
		return "redirect:/";
	}
	
	@RequestMapping("/addNewLicense")
	public String NewLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> unlicensed = lService.getUnlicensedPeople();
		model.addAttribute("persons", unlicensed);
		return "/licenses/addLicense.jsp";
	}
	@RequestMapping(value = "/licenses", method=RequestMethod.POST)
	public String CreateLicense(@Valid @ModelAttribute("license") License lic, BindingResult result) {
		if(result.hasErrors())
			return "/licenses/new.jsp";
		service.createLicense(lic);
		return "redirect:/";
	}
}
