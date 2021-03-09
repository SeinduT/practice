package com.seindu.dogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seindu.dogs.models.Dog;
import com.seindu.dogs.models.Tag;
import com.seindu.dogs.services.DogService;
import com.seindu.dogs.services.TagService;

@Controller
public class DogController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Dog> allDogs = this.dService.getAllDogs();
		viewModel.addAttribute("allDogs", allDogs);
		return "index.jsp";
	}
	
	@GetMapping("/add")
	public String addDog(@ModelAttribute("dog") Dog dog) {
		return "add.jsp";
	}
	
	@PostMapping("/addNewDog")
	public String addNewDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		this.dService.createDog(dog);
		return "redirect:/";
	} 
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("tag") Tag tag, @ModelAttribute("dog") Dog dog) {
		viewModel.addAttribute("dog", this.dService.getSingleDog(id));
		return "show.jsp";
	}
	
	@PostMapping("edit/{id}")
	public String updateDog(@Valid @ModelAttribute("dog") Dog newDog, BindingResult result, @PathVariable("id") Long id, Model viewModel, @ModelAttribute("tag") Tag tag) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", this.dService.getSingleDog(id));
			return "show.jsp";
		}
		this.dService.updateDog(newDog);
		return "redirect:/" + id;
	}
	
	@PostMapping("/addTag")
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model viewModel) {
		Long dogId = tag.getDog().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", this.dService.getSingleDog(dogId));
			return "show.jsp";
		}
		this.tService.create(tag);
		return "redirect:/" + dogId;
	}
	
	// Old way of doing normal HTML Forms + Validation from scratch
	@PostMapping("/addDog")
	public String newDog(@RequestParam("name") String name, @RequestParam("breed") String breed, @RequestParam("age") int age, RedirectAttributes redirectAttrs) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Hey there, you forgot to add a name");
		}
		if(breed.equals("")) {
			errors.add("Hey there, you forgot to add a Breed!");
		}
		if(errors.size() > 0) {
			for(String e: errors) {
				redirectAttrs.addFlashAttribute("errors", e);
				return "redirect:/add";
			}
		}
		this.dService.createDog(name, breed, age);
		return "redirect:/";
	}

}
