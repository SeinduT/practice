package com.seindu.dogs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seindu.dogs.models.Dog;
import com.seindu.dogs.services.DogService;

@RestController
@RequestMapping("/api")
public class APIDogController {
	@Autowired
	private DogService dService;
	
	// Routes
	@GetMapping("")
	public List<Dog> allDogs() {
		return this.dService.getAllDogs();
	}
	
	// Return Single Dog By Id
	@GetMapping("{id}")
	public Dog getOneDog(@PathVariable("id") Long id) {
		return this.dService.getSingleDog(id);
	}
	
	// Create Dog By taking information from the front end
	@PostMapping("")
	public Dog createDog(Dog newDog) {
		return this.dService.createDog(newDog);
	}
	
	// Update Dog
	@PutMapping("/update/{id}")
	public Dog edit(@PathVariable("id") Long id, Dog updatedDog) {
		return this.dService.updateDog(updatedDog);
	}
	
	// Delete Dog By Id
	@DeleteMapping("/delete/{id}")
	public void deleteDog(@PathVariable("id") Long id) {
		this.dService.deleteDog(id);
	}
	
}
 