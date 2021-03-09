package com.seindu.birthdays.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.birthdays.models.Person;
import com.seindu.birthdays.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pRepo;
	
	public List<Person> getPersons() {
		return this.pRepo.findAll();
	}
	
	public Person findById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public Person create(Person person) {
		return this.pRepo.save(person);
	}
	
	public Person updatePerson(Person updatedPerson) {
		return this.pRepo.save(updatedPerson);
	}
	
	public void deletePerson(Long id) {
		this.pRepo.deleteById(id);	
	}
	
	
}
