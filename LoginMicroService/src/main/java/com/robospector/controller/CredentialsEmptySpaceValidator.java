package com.robospector.controller;

import org.springframework.stereotype.Component;

import com.robospector.domain.User;

@Component("loginCredentialsValidatorForController")
public class CredentialsEmptySpaceValidator {

	public void validate(User user) throws SpacesPresentInUserNameOrPasswordException {
		if (user.getUsername().matches(".*\\s.*") || user.getPassword().matches(".*\\s.*")) { // Todo: Magic value to be removed
			throw new SpacesPresentInUserNameOrPasswordException("No Spaces Allowed in Username or Password");
		}
	}
}
