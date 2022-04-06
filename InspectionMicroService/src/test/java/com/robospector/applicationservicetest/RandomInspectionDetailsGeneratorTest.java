package com.robospector.applicationservicetest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.robospector.applicationservice.RandomInspectionDetailsGenerator;
import com.robospector.applicationservice.RandomNumberGenerator;

public class RandomInspectionDetailsGeneratorTest {

	@Mock
	private RandomNumberGenerator randomNumberGenerator;

	@InjectMocks
	private RandomInspectionDetailsGenerator inspectionDetailsGenerator;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		inspectionDetailsGenerator = new RandomInspectionDetailsGenerator(randomNumberGenerator);
	}

	@Test
	public void givenRequestToCreateRandomDateWithLeapYear_whencreateRandomDate_thenReturnRandomDate() {
		when(randomNumberGenerator.generateNumberBetween(anyInt(), anyInt())).thenReturn(2,2021,2);
		
		Object date = inspectionDetailsGenerator.createRandomDate();

		assertTrue(date instanceof LocalDate);

	}

	@Test
	public void givenRequestToCreateRandomTime_whencreateRandomTime_thenReturnRandomTime() {
		when(randomNumberGenerator.generateNumberBetween(anyInt(), anyInt())).thenReturn(2,5,2);

		
		inspectionDetailsGenerator.createRandomTime();

	}

	@Test
	public void givenRequestToCreateRandomCollectingTime_whencreateRandomCollectingTime_thenReturnRandomCollectingTime() {
		when(randomNumberGenerator.generateNumberBetween(anyInt(), anyInt())).thenReturn(5);

		inspectionDetailsGenerator.createRandomCollectingTime();

	}
}
