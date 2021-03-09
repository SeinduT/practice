package com.seindu.greatideas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.greatideas.models.Idea;
import com.seindu.greatideas.models.User;
import com.seindu.greatideas.repositories.IdeaRepository;
import com.seindu.greatideas.repositories.UserRepository;

@Service
public class IdeaService {
	@Autowired
	private IdeaRepository iRepo;
	@Autowired
	private UserRepository uRepo;
	
	public List<Idea> getIdeas() {
		return this.iRepo.findAll();
	}
	
	public Idea findById(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	
	public Idea create(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public Idea updateIdea(Idea updatedIdea) {
		return this.iRepo.save(updatedIdea);
	}
	
	public void deleteIdea(Long id) {
		this.iRepo.deleteById(id);
	}
	
	public void addLikedby(Idea idea, User user) {
		List<User> likedUsers = idea.getLikedby(); 
		likedUsers.add(user);
		this.iRepo.save(idea);
	}
	
	public void removeLikedby(Idea idea, User user) {
		List<User> likedUsers = idea.getLikedby();
		likedUsers.remove(user);
		this.iRepo.save(idea);
	}
}
