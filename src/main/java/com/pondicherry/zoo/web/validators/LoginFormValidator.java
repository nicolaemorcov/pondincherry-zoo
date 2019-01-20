package com.pondicherry.zoo.web.validators;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.pondicherry.zoo.domain.User;
import com.pondicherry.zoo.service.UserService;

public class LoginFormValidator {

	public LoginFormValidator(UserService userService) {
		// TODO Auto-generated constructor stub
	}
	
	Error error;

	public void validate(User command, BindingResult result) {
		if(command.getUsername().isEmpty()) {
			result.addError(new ObjectError("nullUsername", "The username is empty"));
			
		}
		if(command.getPassword().isEmpty()) {
			result.addError(new ObjectError("shortPassword", "The password is too short"));
		}
		
	}

}
