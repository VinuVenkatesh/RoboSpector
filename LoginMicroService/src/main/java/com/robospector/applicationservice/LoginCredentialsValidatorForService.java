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

	private static final int MIN_CREDENTIALS_LENGTH = 8;
	private static final String SPECIAL_CHARACTER_REGEX= "[^A-Za-z0-9 ]";
	
	public void validate(String credentials) throws InvalidUserNameOrPasswordServiceException {
		
		Pattern pattern = Pattern.compile(SPECIAL_CHARACTER_REGEX);
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
	
	public void validateIfUserExists(Optional<User> savedUser) throws UsernameAndPasswordDoNotMatchException {
		if (savedUser.isEmpty()) {
			throw new UsernameAndPasswordDoNotMatchException("Invalid Username or Password");
		}
	}
}
