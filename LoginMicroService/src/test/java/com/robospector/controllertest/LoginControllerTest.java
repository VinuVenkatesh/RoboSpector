package com.robospector.controllertest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.robospector.applicationservice.LoginService;
import com.robospector.controller.LoginController;
import com.robospector.controller.LoginCredentialsValidatorForController;
import com.robospector.controller.NoSpacesInUserNameOrPasswordControllerException;
import com.robospector.domain.User;


public class LoginControllerTest {
	
	private static final String VALID_ADMIN_NAME = "andrew.Warner";
	private static final String VALID_ADMIN_PASSWORD = "Adm!nW@rn3r";
	private static final String VALID_ADMIN_ROLE = "admin";
	private User user;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = new User();
	}
	
	@Mock
	private LoginCredentialsValidatorForController credentialsValidatorForController;
	
	@Mock
	private LoginService loginService;
	
	@InjectMocks
	private LoginController loginController;
	
	@Test
	public void givenValidAdminUserName_whenuserLogin_thenShouldValidateUserName() throws NoSpacesInUserNameOrPasswordControllerException {
		user.setUsername(VALID_ADMIN_NAME);
		user.setPassword(VALID_ADMIN_PASSWORD);
		user.setRole(VALID_ADMIN_ROLE);
		
		loginController.userLogin(user);
		
		verify(credentialsValidatorForController,times(1)).validator(VALID_ADMIN_NAME);
	}
	
	@Test
	public void givenValidAdminPassword_whenuserLogin_thenShouldValidatePassword() throws NoSpacesInUserNameOrPasswordControllerException {
		user.setUsername(VALID_ADMIN_NAME);
		user.setPassword(VALID_ADMIN_PASSWORD);
		user.setRole(VALID_ADMIN_ROLE);
		
		loginController.userLogin(user);
		
		verify(credentialsValidatorForController,times(1)).validator(VALID_ADMIN_PASSWORD);
	}
	
	@Test
	public void givenValidAdmin_whenuserLogin_thenShouldValidatePassword() throws NoSpacesInUserNameOrPasswordControllerException {
		user.setUsername(VALID_ADMIN_NAME);
		user.setPassword(VALID_ADMIN_PASSWORD);
		user.setRole(VALID_ADMIN_ROLE);
		
		loginController.userLogin(user);
		
		verify(credentialsValidatorForController,times(1)).validator(VALID_ADMIN_PASSWORD);
	}
}
