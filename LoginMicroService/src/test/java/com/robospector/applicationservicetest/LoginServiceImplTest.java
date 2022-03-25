package com.robospector.applicationservicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.robospector.applicationservice.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.LoginCredentialsValidatorForService;
import com.robospector.applicationservice.LoginServiceImpl;
import com.robospector.applicationservice.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;
import com.robospector.repository.LoginRepository;

public class LoginServiceImplTest {

	@Mock
	private LoginRepository repository;
	
	@Mock
	private LoginCredentialsValidatorForService credentialsValidatorForService;
	
	private User user;
	
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		user = new User();
		
	}
	
	@Test
	public void userLoginSuccess() throws InvalidUserNameOrPasswordServiceException, UsernameAndPasswordDoNotMatchException {
		user.setUsername("Andrew.Warner");
		user.setPassword("Adm!nW@rn3r");
		user.setRole("admin");
		Mockito.when(repository.findByUsernameAndPassword(user.getUsername(),user.getPassword())).thenReturn(Optional.of(user));
		String userRole = loginServiceImpl.userAuthentication(user);
		assertEquals("admin", userRole);
	}
	
	@Test
	public void userLoginFailed() {
		user.setUsername("maxsize");
		user.setPassword("maxsize");
		user.setRole("admin");
		Mockito.when(repository.findByUsernameAndPassword(user.getUsername(),user.getPassword())).thenReturn(Optional.of(user));
		assertThrows(
				InvalidUserNameOrPasswordServiceException.class,
                    () -> { loginServiceImpl.userAuthentication(user); });
		
	}
}
