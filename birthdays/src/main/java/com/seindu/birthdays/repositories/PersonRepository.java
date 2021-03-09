package com.seindu.birthdays.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seindu.birthdays.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
}
