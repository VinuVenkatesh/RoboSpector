package com.robospector.controller;

import org.springframework.stereotype.Component;

@Component("loginCredentialsValidatorForController")
public class LoginCredentialsValidatorForController {

	public void validator(String credentials) throws NoSpacesInUserNameOrPasswordControllerException {
		
		if (credentials.matches(".*\\s.*")) {
			throw new NoSpacesInUserNameOrPasswordControllerException("No Spaces Allowed in Username or Password");
		}
	}
}
