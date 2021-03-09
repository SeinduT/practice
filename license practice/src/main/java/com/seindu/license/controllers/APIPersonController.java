package com.seindu.license.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seindu.license.models.Person;
import com.seindu.license.services.PersonService;

@RestController
@RequestMapping("/api")
public class APIPersonController {
	@Autowired
	private PersonService pService;
	
	@GetMapping("")
	public List<Person> allPersons(){
		return this.pService.getAllPersons();
	}
	
	@GetMapping("{id}")
	public Person getOnePerson(@PathVariable("id") Long id) {
		return this.pService.getSinglePerson(id);
	}
	
	@PostMapping("/")
	public Person createPerson(Person newPerson) {
		return this.pService.createPerson(newPerson);
	}

}
