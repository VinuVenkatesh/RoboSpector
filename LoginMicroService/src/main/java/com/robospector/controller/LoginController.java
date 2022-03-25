package com.robospector.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("")
	public String pingTest() {
		return "Login service is alive";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody User user) {
		
		try {
			credentialsValidatorForController.validator(user.getUsername());
			credentialsValidatorForController.validator(user.getPassword());
			return new ResponseEntity<>(service.authenticateUser(user), HttpStatus.OK);
		} catch (NoSpacesInUserNameOrPasswordControllerException | UsernameAndPasswordDoNotMatchException | InvalidUserNameOrPasswordServiceException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
		

	}
}
