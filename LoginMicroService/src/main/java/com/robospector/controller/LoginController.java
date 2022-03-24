package com.robospector.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robospector.applicationservice.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.LoginService;
import com.robospector.applicationservice.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@Autowired
	@Qualifier("loginCredentialsValidatorForController")
	private LoginCredentialsValidatorForController credentialsValidatorForController;
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody User user) throws NoSpacesInUserNameOrPasswordControllerException {
		
		Optional<String> validUser = credentialsValidatorForController.validator(user.getUsername());
		Optional<String> validPassword = credentialsValidatorForController.validator(user.getPassword());
		
		if(!validUser.isEmpty() || !validPassword.isEmpty()) {
			throw new NoSpacesInUserNameOrPasswordControllerException();
		}
		else {
			try {
				return new ResponseEntity<>(service.userAuthentication(user), HttpStatus.OK);
			} catch (UsernameAndPasswordDoNotMatchException | InvalidUserNameOrPasswordServiceException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		}
	}
}
