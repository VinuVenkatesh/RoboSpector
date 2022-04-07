package com.robospector.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class StringToTimeConverterTest {

	private final static int HOUR = 2;
	private final static int MINUTES = 20;
	private final static int SECONDS = 30;
	private final static String TIME = "02:20:30";
	
	@InjectMocks
	StringToTimeConverter stringToTimeConverter;
	
	@BeforeEach
	public void setUp() {
		stringToTimeConverter = new StringToTimeConverter();
	}
	
	@Test
	public void givenRequestToConvertStringToTime_whenConvert_thenShouldReturnTimeAsInstanceOfLocalTime() {
		Object object = stringToTimeConverter.convert(TIME);
		
		assertTrue(object instanceof LocalTime);
		assertEquals(LocalTime.of(HOUR, MINUTES, SECONDS), object);
		
	}
}
