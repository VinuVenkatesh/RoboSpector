package com.robospector.applicationservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.robospector.applicationservice.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.LoginCredentialsValidatorForService;
import com.robospector.applicationservice.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;

public class LoginCredentialsValidatorForServiceTest {

	private LoginCredentialsValidatorForService credentialsValidatorForService;
	private static final String CREDENTIALS_WITH_INVALID_LENGTH = "qweasd";
	private static final String CREDENTIALS_WITH_NO_CAPITALS = "qweasdzxc";
	private static final String CREDENTIALS_WITH_NO_SPECIALCHARACTERS = "Qweasdzxc";
	private static final String INVALID_LENGTH_ERROR_MESSAGE = "Username and Password must be atleast 8 characters long";
	private static final String NO_CAPITALS_ERROR_MESSAGE = "Username and Password must contain atleast 1 uppercase";
	private static final String NO_SPECIALCHARACTERS_ERROR_MESSAGE = "Username and Password must contain atleast 1 special character";
	private static final String VALID_CREDENTIALS = "Qweasdzxc!";
	private static final Optional<User> EMPTY_OPTIONAL_OBJECT = Optional.empty();
	private static final String INVALID_CREDENTIALS_ERROR = "Invalid Username or Password";
	private static final Optional<User> VALID_OPTIONAL_OBJECT = Optional.of(new User());
	
	@BeforeEach
	public void setUp() {
		credentialsValidatorForService = new LoginCredentialsValidatorForService();
	}
	
	@Test
	public void givenCredentialsWithLessThenAllowedSize_whenValidate_thenThrowInvalidUserNameOrPasswordServiceException() {
		try {
			credentialsValidatorForService.validate(CREDENTIALS_WITH_INVALID_LENGTH);
			fail();
		} catch (InvalidUserNameOrPasswordServiceException e) {
			assertEquals(INVALID_LENGTH_ERROR_MESSAGE, e.getMessage());
		}
	}
	
	@Test
	public void givenCredentialsWithNoCapitals_whenValidate_thenThrowInvalidUserNameOrPasswordServiceException() {
		try {
			credentialsValidatorForService.validate(CREDENTIALS_WITH_NO_CAPITALS);
			fail();
		} catch (InvalidUserNameOrPasswordServiceException e) {
			assertEquals(NO_CAPITALS_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void givenCredentialsWithNoSpecialCharacters_whenValidate_thenThrowInvalidUserNameOrPasswordServiceException() {
		try {
			credentialsValidatorForService.validate(CREDENTIALS_WITH_NO_SPECIALCHARACTERS);
			fail();
		} catch (InvalidUserNameOrPasswordServiceException e) {
			assertEquals(NO_SPECIALCHARACTERS_ERROR_MESSAGE, e.getMessage());
		}
	}

	@Test
	public void givenValidCredentials_whenValidate_thenNoExceptionsThrown() {
		try {
			credentialsValidatorForService.validate(VALID_CREDENTIALS);
		} catch (InvalidUserNameOrPasswordServiceException e) {
			fail();
		}
	}
	
	@Test
	public void givenEmptyOptionalObject_whenIsEmpty_thenThrowUsernameAndPasswordDoNotMatchException() {
		try {
			credentialsValidatorForService.isEmpty(EMPTY_OPTIONAL_OBJECT);
			fail();
		} catch (UsernameAndPasswordDoNotMatchException e) {
			assertEquals(INVALID_CREDENTIALS_ERROR, e.getMessage());
		}
	}
	
	@Test
	public void givenValidOptionalObject_whenIsEmpty_thenNoExceptionsThrown() {
		try {
			credentialsValidatorForService.isEmpty(VALID_OPTIONAL_OBJECT);
		} catch (UsernameAndPasswordDoNotMatchException e) {
			fail();
		}
	}
}
