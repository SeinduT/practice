package com.seindu.events.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.seindu.events.models.User;
import com.seindu.events.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password",  "Match", "Passwords do not match, Try again");
		}
		
		// make sure email is unique in the database
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "This email has already been registered");
		}
		

	}
}
