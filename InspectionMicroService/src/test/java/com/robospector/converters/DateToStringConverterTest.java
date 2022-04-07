package com.robospector.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class DateToStringConverterTest {
	
	private final static int YEAR = 2021;
	private final static int DAY = 05;
	private final static int MONTH = 10;
	private final static String DATE = "2021-10-05";
	
	@InjectMocks
	DateToStringConverter dateToStringConverter;
	
	@BeforeEach
	public void setUp() {
		dateToStringConverter = new DateToStringConverter();
	}
	
	@Test
	public void givenRequestToConvertDateToString_whenConvert_ThenShouldReturnDateAsString() {
		Object object = dateToStringConverter.convert(LocalDate.of(YEAR, MONTH, DAY));
		
		assertTrue(object instanceof String);
		assertEquals(DATE, object);
		
	}
}
