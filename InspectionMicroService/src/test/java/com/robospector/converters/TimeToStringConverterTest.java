package com.robospector.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class TimeToStringConverterTest {

	private final static int HOUR = 2;
	private final static int MINUTES = 20;
	private final static int SECONDS = 30;
	private final static String TIME = "02:20:30";
	
	@InjectMocks
	TimeToStringConverter timeToStringConverter;

	@BeforeEach
	public void setUp() {
		timeToStringConverter = new TimeToStringConverter();
	}
	
	@Test
	public void givenRequestToConvertTimeToString_whenConvert_thenShouldReturnTimeAsString() {
		Object object = timeToStringConverter.convert(LocalTime.of(HOUR, MINUTES, SECONDS));
		
		assertTrue(object instanceof String);
		assertEquals(TIME, object);
	}
}
