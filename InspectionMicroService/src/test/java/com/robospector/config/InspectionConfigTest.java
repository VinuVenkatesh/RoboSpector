package com.robospector.config;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.robospector.applicationservice.RandomInspectionDetailsGenerator;
import com.robospector.applicationservice.RandomNumberGenerator;
import com.robospector.config.InspectionConfig;

public class InspectionConfigTest {

	@InjectMocks
	InspectionConfig inspectionConfig;
	
	@BeforeEach
	public void setUp() {
		inspectionConfig = new InspectionConfig();
	}
	
	@Test
	public void givenRequestForMongoCustomConversions_whencustomConversions_thenShouldReturnInstanceOfMongoCustomConversions(){
		Object object = inspectionConfig.customConversions();
		
		assertTrue(object instanceof MongoCustomConversions );
	}
	
	@Test
	public void givenRequestForModelMapper_whenGetModelMapper_thenShouldReturnInstanceOfModelMapper() {
		Object object = inspectionConfig.getModelMapper();
		
		assertTrue(object instanceof ModelMapper);
	}
	
	@Test
	public void givenReuquestForWebMvcConfigurer_whenCorsConfigurer_thenShouldReturnInstanceOfWebMvcConfigurer(){
		Object object = inspectionConfig.corsConfigurer();
		inspectionConfig.corsConfigurer().addCorsMappings(new CorsRegistry());
		
		assertTrue(object instanceof WebMvcConfigurer);
	}
	
	@Test
	public void givenRequestForRandomNumberGenerator_whenGetRandomNumberGenerator_thenShouldReturnInstanceOfRandomNumberGenerator() {
		Object object = inspectionConfig.getRandomNumberGenerator();
		assertTrue(object instanceof RandomNumberGenerator);
	}
	
	@Test
	public void givenRequestForRandomInspectionDetailsGenerator_whenGetDetailsGenerator_thenShouldReturnInstanceOfRandomInspectionDetailsGenerator() {
		Object object = inspectionConfig.detailsGenerator();
		
		assertTrue(object instanceof RandomInspectionDetailsGenerator);
	}
}
