package com.robospector.applicationservice;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.robospector.applicationservice.exception.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.exception.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;

@Component("loginCredentialsValidatorForService")
public class LoginCredentialsValidatorForService {

	private static final int MAX_PASSWORD_SIZE = 8;
	
	public void validator(String credentials) throws InvalidUserNameOrPasswordServiceException {
		
		Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher matcher = pattern.matcher(credentials);
        
		if(credentials.length() < MAX_PASSWORD_SIZE) {
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
