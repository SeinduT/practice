package com.seindu.greatideas.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.greatideas.models.User;
import com.seindu.greatideas.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User findUserById(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> allUsers() {
		return this.uRepo.findAll();
	}
	
	//Register A User and Hash the password
	public User registerUser(User user) {
		// Generate The Hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// Set the hashed password on the users password field
		user.setPassword(hash);
		// Save that new user passord to the databaase
		return this.uRepo.save(user);
	}
	
	// Login / Authenticate
	public boolean authenticateUser(String email, String password) {
		//Make sure the user loggin in is who they say they are
		// Step:1 try and query for the user by email
		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		
		// Step: 2 check lprovided email aginst email in the database for user
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
}
