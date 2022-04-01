package com.robospector.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import com.robospector.applicationservice.LoginService;
import com.robospector.applicationservice.exception.InvalidUserNameOrPasswordServiceException;
import com.robospector.controller.LoginController;
import com.robospector.controller.CredentialsEmptySpaceValidator;
import com.robospector.controller.SpacesPresentInUserNameOrPasswordException;
import com.robospector.domain.User;

public class LoginControllerTest {

	private static final String A_VALID_ADMIN_NAME = "andrew.Warner";
	private static final String A_VALID_ADMIN_PASSWORD = "Adm!nW@rn3r";
	private static final String ADMIN_ROLE = "admin";
	private static final String ADMIN_NAME_WITH_SPACES = "dsa  dasdsassss";
	private static final String ADMIN_PASSWORD_WITH_SPACES = "dsa  dsadsawww";
	private static final String AN_INVALID_ADMIN_NAME = "test123213";
	private static final String AN_INVALID_ADMIN_PASSWORD = "qwesadzxc123";
	
	private User user;
	
	@Mock
	private CredentialsEmptySpaceValidator credentialsValidatorForController;

	@Mock
	private LoginService loginService;

	@InjectMocks
	private LoginController loginController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = new User();
	}
	
	@Test
	public void givenValidAdminCredentials_whenLogin_thenShouldCheckForUserCredentialsEmptySpaces()
			throws SpacesPresentInUserNameOrPasswordException {
		user.setUsername(A_VALID_ADMIN_NAME);
		user.setPassword(A_VALID_ADMIN_PASSWORD);
		user.setRole(ADMIN_ROLE);

		loginController.login(user);

		verify(credentialsValidatorForController, times(1)).validate(user);
	}
	
	@Test
	public void givenAdminCredentialsWithSpaces_whenLogin_thenShouldReturnNotFoundStatus() throws Exception {
		user.setUsername(ADMIN_NAME_WITH_SPACES);
		user.setPassword(ADMIN_PASSWORD_WITH_SPACES);
		user.setRole(ADMIN_ROLE);
		
		doThrow(SpacesPresentInUserNameOrPasswordException.class).when(credentialsValidatorForController).validate(user);
		ResponseEntity<?> responseEntity =  loginController.login(user);
		
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		verify(credentialsValidatorForController, times(1)).validate(user);
	}

	@Test
	public void givenInvalidAdminCredentials_whenLogin_thenShouldReturnNotFoundStatus() throws Exception {
		user.setUsername(AN_INVALID_ADMIN_NAME);
		user.setPassword(AN_INVALID_ADMIN_PASSWORD);
		user.setRole(ADMIN_ROLE);
		
		doThrow(InvalidUserNameOrPasswordServiceException.class).when(loginService).authenticateUser(user);
		ResponseEntity<?> responseEntity =  loginController.login(user);
		
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		verify(loginService, times(1)).authenticateUser(user);
	}
	
	
/*
	@Test
	public void givenValidAdmin_whenuserLogin_thenShouldValidatePassword()
			throws NoSpacesInUserNameOrPasswordControllerException {
		user.setUsername(A_VALID_ADMIN_NAME);
		user.setPassword(A_VALID_ADMIN_PASSWORD);
		user.setRole(ADMIN_ROLE);

		loginController.login(user);

		verify(credentialsValidatorForController, times(1)).validate(A_VALID_ADMIN_PASSWORD);
	}
	*/
}
