package com.robospector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:4200/")
						.allowedMethods("GET","POST")
						.allowedHeaders("*")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}
}
