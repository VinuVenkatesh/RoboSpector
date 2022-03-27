package com.robospector.controllertest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.robospector.applicationservice.LoginService;
import com.robospector.controller.LoginController;
import com.robospector.controller.CredentialsEmptySpaceValidator;
import com.robospector.controller.SpacesPresentInUserNameOrPasswordException;
import com.robospector.domain.User;

public class LoginControllerTest {

	private static final String A_VALID_ADMIN_NAME = "andrew.Warner";
	private static final String A_VALID_ADMIN_PASSWORD = "Adm!nW@rn3r";
	private static final String ADMIN_ROLE = "admin";
	private User user;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = new User();
	}

	@Mock
	private CredentialsEmptySpaceValidator credentialsEmptySpaceValidator;

	@Mock
	private LoginService loginService;

	@InjectMocks
	private LoginController loginController;

	@Test
	public void givenAValidAdminUserName_whenLogin_thenShouldCheckForUserCredentialsEmptySpaces()
			throws SpacesPresentInUserNameOrPasswordException {
		user.setUsername(A_VALID_ADMIN_NAME);
		user.setPassword(A_VALID_ADMIN_PASSWORD);
		user.setRole(ADMIN_ROLE);

		loginController.login(user);

		verify(credentialsEmptySpaceValidator, times(1)).validate(user);
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
