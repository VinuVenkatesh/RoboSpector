package com.robospector.applicationservice;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("loginCredentialsValidatorForService")
public class LoginCredentialsValidatorForService {

	private static final int MAX_PASSWORD_SIZE = 8;
	
	public Optional<String> validator(String credentials) {
		
		Optional<String> errorMessage = Optional.empty();
		Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher matcher = pattern.matcher(credentials);
        
		if(credentials.length() < MAX_PASSWORD_SIZE) {
			errorMessage = Optional.of("Username and Password must be atleast 8 characters long");
		}
		else if(!credentials.chars().anyMatch(Character::isUpperCase)) {
			errorMessage = Optional.of("Username and Password must contain atleast 1 uppercase");
		}
		else if(!matcher.find()) {
        	errorMessage = Optional.of("Username and Password must contain atleast 1 special character");
        }
		
        return errorMessage;
	}
}
