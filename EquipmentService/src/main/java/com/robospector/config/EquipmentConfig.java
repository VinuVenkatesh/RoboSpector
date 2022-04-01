package com.robospector.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.robospector.controller.PieceOfEquipmentDtoValidator;
import com.robospector.controller.RandomNumberGenerator;

@Configuration
public class EquipmentConfig {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public PieceOfEquipmentDtoValidator getPieceOfEquipmentDtoValidator() {
		return new PieceOfEquipmentDtoValidator();
	}
	
	@Bean
	public RandomNumberGenerator getRandomNumberGenerator() {
		return new RandomNumberGenerator();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:4200/")
						.allowedMethods("GET","POST","PUT")
						.allowedHeaders("*")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}
}
