package com.robospector.applicationservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.robospector.applicationservice.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.LoginCredentialsValidatorForService;
import com.robospector.applicationservice.LoginServiceImpl;
import com.robospector.applicationservice.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;
import com.robospector.repository.LoginRepository;

public class LoginServiceImplTest {

	private static final String VALID_ADMIN_NAME = "andrew.Warner";
	private static final String VALID_ADMIN_PASSWORD = "Adm!nW@rn3r";
	private static final String VALID_ADMIN_ROLE = "admin";
	@Mock
	private LoginRepository loginRepository;

	@Mock
	private LoginCredentialsValidatorForService credentialsValidatorForService;

	private User user;

	@InjectMocks
	private LoginServiceImpl loginService;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		user = new User();

	}

	@Test
	public void givenValidAdminUserName_whenAuthenticateUser_thenShouldValidateUserName()
			throws InvalidUserNameOrPasswordServiceException, UsernameAndPasswordDoNotMatchException {
		user.setUsername(VALID_ADMIN_NAME);
		user.setPassword(anyString());
		user.setRole(anyString());
		when(loginRepository.findByUsernameAndPassword(VALID_ADMIN_NAME, VALID_ADMIN_PASSWORD))
				.thenReturn(Optional.ofNullable(user));

		loginService.authenticateUser(user);

		verify(credentialsValidatorForService, times(1)).validate(VALID_ADMIN_NAME);
	}
	
	@Test
	public void givenValidAdminPassword_whenAuthenticateUser_thenShouldValidatePassword()
			throws InvalidUserNameOrPasswordServiceException, UsernameAndPasswordDoNotMatchException {
		user.setUsername(anyString());
		user.setPassword(VALID_ADMIN_PASSWORD);
		user.setRole(anyString());
		when(loginRepository.findByUsernameAndPassword(VALID_ADMIN_NAME, VALID_ADMIN_PASSWORD))
				.thenReturn(Optional.ofNullable(user));

		loginService.authenticateUser(user);

		verify(credentialsValidatorForService, times(1)).validate(VALID_ADMIN_PASSWORD);
	}
	
	@Test
	public void givenValidAdminCredentials_whenAuthenticateUser_thenShouldReturnValidAdmin()
			throws InvalidUserNameOrPasswordServiceException, UsernameAndPasswordDoNotMatchException {
		user.setUsername(VALID_ADMIN_NAME);
		user.setPassword(VALID_ADMIN_PASSWORD);
		user.setRole(VALID_ADMIN_ROLE);
		when(loginRepository.findByUsernameAndPassword(VALID_ADMIN_NAME, VALID_ADMIN_PASSWORD))
				.thenReturn(Optional.ofNullable(user));

		loginService.authenticateUser(user);

		verify(loginRepository, times(1)).findByUsernameAndPassword(VALID_ADMIN_NAME, VALID_ADMIN_PASSWORD);
	}
	
	@Test
	public void givenValidAdminCredentials_whenAuthenticateUser_thenShouldCheckIfAdminIsEmpty()
			throws InvalidUserNameOrPasswordServiceException, UsernameAndPasswordDoNotMatchException {
		user.setUsername(VALID_ADMIN_NAME);
		user.setPassword(VALID_ADMIN_PASSWORD);
		user.setRole(VALID_ADMIN_ROLE);
		when(loginRepository.findByUsernameAndPassword(VALID_ADMIN_NAME, VALID_ADMIN_PASSWORD))
				.thenReturn(Optional.ofNullable(user));

		loginService.authenticateUser(user);

		verify(credentialsValidatorForService, times(1)).isEmpty(Optional.ofNullable(user));
	}
	
	@Test
	public void givenValidAdminCredentials_whenAuthenticateUser_thenShouldReturnValidRole()
			throws InvalidUserNameOrPasswordServiceException, UsernameAndPasswordDoNotMatchException {
		user.setUsername(VALID_ADMIN_NAME);
		user.setPassword(VALID_ADMIN_PASSWORD);
		user.setRole(VALID_ADMIN_ROLE);
		when(loginRepository.findByUsernameAndPassword(VALID_ADMIN_NAME, VALID_ADMIN_PASSWORD))
				.thenReturn(Optional.ofNullable(user));

		String role = loginService.authenticateUser(user);

		verify(credentialsValidatorForService, times(1)).validate(VALID_ADMIN_PASSWORD);
		assertEquals(VALID_ADMIN_ROLE, role);
	}
}
