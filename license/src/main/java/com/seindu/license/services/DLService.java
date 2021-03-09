package com.seindu.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.license.models.License;
import com.seindu.license.models.Person;
import com.seindu.license.repositories.LicenseRepository;
import com.seindu.license.repositories.PersonRepository;

@Service
public class DLService {
	@Autowired
	private PersonRepository pRepo;
	private LicenseRepository lRepo;
	
	// Retrieve All
	public List<Person> getPeople() {
		return pRepo.findAll();
	}
	
	public List<Person> getNoLicensePeople() {
		return pRepo.findByLicenseIdIsNull();
	}
	
	// Retrieve One
	public Person getPerson(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	
	// Create
	public Person createPerson(Person p) {
		return pRepo.save(p);
	}
	public License createLicense(License l) {
		l.setNumber(this.generateLicenseNumber());
		return lRepo.save(l);
	}
	
	public int generateLicenseNumber() {
		License l = lRepo.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		int largestNumber = l.getNumber();
		largestNumber++;
		return (largestNumber);
	}
	// Read
	
	
	
	// Update
	
	
	// Delete
	
	
	

}
