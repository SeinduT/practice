package com.seindu.dogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.dogs.models.Tag;
import com.seindu.dogs.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	// Create
	
	public Tag create(Tag tag) {
		return this.tRepo.save(tag);
	}
}
