package com.robospector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.robospector.applicationservice.LoginCredentialsValidatorForService;
import com.robospector.controller.CredentialsEmptySpaceValidator;

@Configuration
public class LoginConfig {

	@Bean
	public LoginCredentialsValidatorForService getCredentialsValidatorForService() {
		return new LoginCredentialsValidatorForService();
	}
	
	@Bean
	public CredentialsEmptySpaceValidator getCredentialsValidatorForController() {
		return new CredentialsEmptySpaceValidator();
	}
}
