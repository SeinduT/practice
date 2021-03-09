package com.seindu.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seindu.license.models.License;
import com.seindu.license.models.Person;
import com.seindu.license.services.DLService;

@Controller
public class licenseController {
	@Autowired
	private DLService dServ;
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		List<Person> people = dServ.getPeople();
		viewModel.addAttribute("persons", people);
		return "index.jsp";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST) 
	public String CreatePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors() ) {
			return "new.jsp";
		}
		dServ.createPerson(person);
		return "redirect:/";
	}
	
	@RequestMapping("/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("person", dServ.getPerson(id));
		return "show.jsp";
	}
	
	@RequestMapping("/new")
	public String NewPerson(@ModelAttribute("person") Person person) {
		return "new.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String NewLicense(@Valid @ModelAttribute("license") License l, Model viewModel) {
		List<Person> nolicense = dServ.getNoLicensePeople();
		viewModel.addAttribute("persons", nolicense);
		return "licenses.jsp";
	}
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String CreateLicense(@Valid @ModelAttribute("license") License l, BindingResult result) {
		if (result.hasErrors())
			return "licenses.jsp";
		dServ.createLicense(l);
		return "redirect:/";
	}
	

}
