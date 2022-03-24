package com.robospector.controller;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component("loginCredentialsValidatorForController")
public class LoginCredentialsValidatorForController {

	public Optional<String> validator(String credentials) {
		
		Optional<String> errorMessage = Optional.empty();
		
		if (credentials.matches(".*\\s.*")) {
			errorMessage = Optional.of("No Spaces Allowed in UserName or Password");
		}
		
		return errorMessage;
	}
}
