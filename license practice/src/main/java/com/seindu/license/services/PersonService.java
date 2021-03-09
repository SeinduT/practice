package com.seindu.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.license.models.License;
import com.seindu.license.models.Person;
import com.seindu.license.repositories.LicenseRepository;
import com.seindu.license.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pRepo;
	@Autowired
	private LicenseRepository lRepo;
	
	public List<Person> getAllPersons() {
		return this.pRepo.findAll();
	}
	
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	public Person createPerson(String firstName, String lastName) {
		Person newPerson = new Person(firstName, lastName);
		return this.pRepo.save(newPerson);
	}
	
	public Person getSinglePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
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
}
