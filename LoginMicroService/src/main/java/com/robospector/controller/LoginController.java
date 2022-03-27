package com.robospector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robospector.applicationservice.LoginService;
import com.robospector.applicationservice.exception.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.exception.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;
import com.robospector.repository.LoginRepository;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;
	
	@Autowired
	private  LoginRepository loginRepository;

	@Autowired
	@Qualifier("loginCredentialsValidatorForController")
	private CredentialsEmptySpaceValidator credentialsValidatorForController;

	@GetMapping("")
	public String pingTest() {
		return "Login service is alive";
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllUsers() {
		List<User> allUsers = loginRepository.findAll();
		
		if(allUsers.isEmpty()) {
			return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		try {
			credentialsValidatorForController.validate(user);
			return new ResponseEntity<>(service.authenticateUser(user), HttpStatus.OK);
		} catch (SpacesPresentInUserNameOrPasswordException | UsernameAndPasswordDoNotMatchException
				| InvalidUserNameOrPasswordServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
