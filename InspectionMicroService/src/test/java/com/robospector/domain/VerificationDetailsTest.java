package com.robospector.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VerificationDetailsTest {

	final private static int VERIFIED_BY = 1;
	final private static InspectionResult INSPECTION_RESULT = new InspectionResult();
	final private static String ENGINEER_COMMENT = "Test comment";
	
	@Test
	public void givenVerificationDetailsValues_whenVerificationDetails_thenShouldStoreValuesInsideVerificationDetails(){
	
		VerificationDetails verificationDetails = new VerificationDetails(VERIFIED_BY,INSPECTION_RESULT,ENGINEER_COMMENT);
		
		assertEquals(ENGINEER_COMMENT, verificationDetails.getEngineerComment());
	}
}
