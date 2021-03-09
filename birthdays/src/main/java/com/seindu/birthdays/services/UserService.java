package com.seindu.birthdays.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.birthdays.models.User;
import com.seindu.birthdays.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User findUserById(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
}
