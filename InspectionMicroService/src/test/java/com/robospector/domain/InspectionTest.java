package com.robospector.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InspectionTest {

	final private static int EQUIPMENT_ID = 1;
	final private static int COLLECTING_TIME = 10;
	final private static VerificationDetails VERIFICATIONDETAILS = new VerificationDetails();
	
	@Test
	public void givenInspectionValues_whenInspection_thenShouldStoreValuesInsideInspection(){
		Inspection inspection = new Inspection(EQUIPMENT_ID,COLLECTING_TIME,VERIFICATIONDETAILS);
		assertEquals(EQUIPMENT_ID, inspection.getEquipmentId());
	}
}
