package com.robospector.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
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
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {

		Map<String, String> tokenMap = new HashMap<>();

		try {
			credentialsValidatorForController.validate(user);
			User authenticatedUser = service.authenticateUser(user);
			
			String jwtToken = service.generateJwtToken(user.getUsername());
			tokenMap.put("token", jwtToken);
			tokenMap.put("userRole", authenticatedUser.getRole());
			return new ResponseEntity<>(tokenMap, HttpStatus.OK);
		} catch (SpacesPresentInUserNameOrPasswordException |
				UsernameAndPasswordDoNotMatchException |
				InvalidUserNameOrPasswordServiceException e) {
			tokenMap.put("message", e.getMessage());
			
			return new ResponseEntity<>(tokenMap,HttpStatus.NOT_FOUND);
		}
	}
}
