package com.robospector.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InspectionResultTest {
	
	final private static int SEVERITY = 1;
	final private static String NAME = "test";
	
	@Test
	public void givenInspectionValues_whenInspection_thenShouldStoreValuesInsideInspection(){
		InspectionResult inspectionResult = new InspectionResult(NAME,SEVERITY);
	
		assertEquals(SEVERITY, inspectionResult.getSeverity());
	}
}
