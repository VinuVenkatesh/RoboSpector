package com.robospector.config;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.robospector.applicationservice.RandomInspectionDetailsGenerator;
import com.robospector.applicationservice.RandomNumberGenerator;
import com.robospector.converters.DateToStringConverter;
import com.robospector.converters.StringToTimeConverter;
import com.robospector.converters.TimeToStringConverter;

@Configuration
public class InspectionConfig{


	@Bean
	public MongoCustomConversions customConversions() {
		List<Converter<?, ?>> converters = new ArrayList<>();
		converters.add(new StringToTimeConverter());
		converters.add(new DateToStringConverter());
		converters.add(new TimeToStringConverter());
		return new MongoCustomConversions(converters);
	}
	
	@Bean
	public RandomInspectionDetailsGenerator detailsGenerator () {
		return new RandomInspectionDetailsGenerator(getRandomNumberGenerator());
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
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
	@Bean
	public RandomNumberGenerator getRandomNumberGenerator() {
		return new RandomNumberGenerator();
	}
}
