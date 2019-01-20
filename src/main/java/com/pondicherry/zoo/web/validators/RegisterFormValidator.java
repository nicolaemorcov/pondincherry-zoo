package com.pondicherry.zoo.web.validators;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.pondicherry.zoo.domain.User;
import com.pondicherry.zoo.service.UserService;

public class RegisterFormValidator {

	public RegisterFormValidator(UserService userService) {
		// TODO Auto-generated constructor stub
	}
	
	Error error;
	
	public void validate(User command, BindingResult bindingResult) {
		if(command.getUsername().isEmpty()) {
			bindingResult.addError(new ObjectError("nullUsername", "The Username is empty"));
		}
		if(command.getPassword().isEmpty()) {
			bindingResult.addError(new ObjectError("nullPassword", "The password is empty"));
		}
		if(!command.getSex().equals(command.getSex().F) || !command.getSex().equals(command.getSex().M)) {
			bindingResult.addError(new ObjectError("nullSex", "The Sex is empty"));
		}
		if(command.getPostcode().isEmpty()) {
			bindingResult.addError(new ObjectError("nullPostcode", "The Postcode is empty"));
		}
	}
	
	

}
