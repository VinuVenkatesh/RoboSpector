package com.robospector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.robospector.applicationservice.LoginCredentialsValidatorForService;
import com.robospector.controller.LoginCredentialsValidatorForController;

@Configuration
public class LoginConfig {

	@Bean
	public LoginCredentialsValidatorForService getCredentialsValidatorForService() {
		return new LoginCredentialsValidatorForService();
	}
	
	@Bean
	public LoginCredentialsValidatorForController getCredentialsValidatorForController() {
		return new LoginCredentialsValidatorForController();
	}
}
