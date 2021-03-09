package com.seindu.loginandreg.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.seindu.loginandreg.Repositories.UserRepository;
import com.seindu.loginandreg.models.User;

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
			errors.rejectValue("password",  "Match", "Stop, Passwords do not match");
		}
		
		// make sure email is unique in the database
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique", "This email has already been registered");
		}
		
		if(user.getFirstName().equals("Seindu")) {
			errors.rejectValue("firstName", "nameNotAllowed", "Sorry you are banned.");
		}
	}
}
