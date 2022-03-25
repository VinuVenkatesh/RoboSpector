package com.robospector.applicationservice;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.robospector.domain.User;

@Component("loginCredentialsValidatorForService")
public class LoginCredentialsValidatorForService {

	private static final int MIN_CREDENTIALS_LENGTH = 8;
	
	public void validate(String credentials) throws InvalidUserNameOrPasswordServiceException {
		System.out.println("test");
		Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher matcher = pattern.matcher(credentials);
        
		if(credentials.length() < MIN_CREDENTIALS_LENGTH) {
			throw new InvalidUserNameOrPasswordServiceException("Username and Password must be atleast 8 characters long");
		}
		else if(!credentials.chars().anyMatch(Character::isUpperCase)) {
			throw new InvalidUserNameOrPasswordServiceException("Username and Password must contain atleast 1 uppercase");
		}
		else if(!matcher.find()) {
			throw new InvalidUserNameOrPasswordServiceException("Username and Password must contain atleast 1 special character");
        }
		
	}
	
	public void isEmpty(Optional<User> savedUser) throws UsernameAndPasswordDoNotMatchException {
		if (savedUser.isEmpty()) {
			throw new UsernameAndPasswordDoNotMatchException("Invalid Username or Password");
		}
	}
}
