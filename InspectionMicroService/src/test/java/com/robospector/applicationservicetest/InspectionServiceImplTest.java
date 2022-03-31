package com.robospector.applicationservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.robospector.applicationservice.InspectionServiceImpl;
import com.robospector.applicationservice.RandomInspectionDetailsGenerator;
import com.robospector.applicationservice.exception.NoSuchInspectionException;
import com.robospector.domain.Inspection;
import com.robospector.domain.InspectionResult;
import com.robospector.domain.VerificationDetails;
import com.robospector.repository.InspectionRepository;

public class InspectionServiceImplTest {

	private static final String VALID_EQUIPMENT_NAME = "test";
	private static final String INVALID_EQUIPMENT_NAME = "test123";
	private static final String INSPECTION_ERROR_MESSAGE_1 = "No inspections exist for this equipment";
	private static final String INSPECTION_ERROR_MESSAGE_2 = "The inspection does not exist";
	private static final String ENGINEER_COMMENT = "This is a test comment";
	private static final int ENGINEER_ID = 1;
	private static final InspectionResult INSPECTION_RESULT = new InspectionResult();
	private static final int SEVERITY = 2;
	private static final String NAME = "Minor wear";
	private static final String VALID_INSPECTION_ID = "321321231";
	private static final String INVALID_INSPECTION_ID = "123";
	
	@Mock
	private InspectionRepository inspectionRepository;
	
	@Mock
	private RandomInspectionDetailsGenerator detailsGenerator;
	
	private List<Inspection> inspectionList;
	private Inspection inspection;
	private VerificationDetails verificationDetails;
	
	@InjectMocks
	private InspectionServiceImpl inspectionService;
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		inspectionList = new ArrayList<>();
		Inspection obj = new Inspection();
		obj.setCollectingTime(detailsGenerator.createRandomCollectingTime());
		obj.setDateTime();
		obj.getDateTime().setRandomDate(detailsGenerator.createRandomDate());
		obj.getDateTime().setRandomTime(detailsGenerator.createRandomTime());
		obj.setName(VALID_EQUIPMENT_NAME);
		inspectionList.add(obj);
		inspection = obj;
		inspection.setId(VALID_INSPECTION_ID);
		obj.setCollectingTime(detailsGenerator.createRandomCollectingTime());
		obj.setDateTime();
		obj.getDateTime().setRandomDate(detailsGenerator.createRandomDate());
		obj.getDateTime().setRandomTime(detailsGenerator.createRandomTime());
		obj.setName(VALID_EQUIPMENT_NAME);
		inspectionList.add(obj);
		verificationDetails = new VerificationDetails();
		verificationDetails.setEngineerComment(ENGINEER_COMMENT);
		verificationDetails.setVerifiedBy(ENGINEER_ID);
		INSPECTION_RESULT.setName(NAME);
		INSPECTION_RESULT.setSeverity(SEVERITY);
		verificationDetails.setInspectionResult(INSPECTION_RESULT);
		inspection.setVerificationDetails(verificationDetails);
	}
	
	@Test
	public void givenValidEquipmentName_whenGetAllInspections_thenShouldReturnListOfInspectionsForThatEquipment() throws NoSuchInspectionException {
		when(inspectionRepository.findByNameOrderByVerificationDetailsInspectionResultSeverityDesc(VALID_EQUIPMENT_NAME)).thenReturn(inspectionList);
		
		List<Inspection> list = inspectionService.getAllInspections(VALID_EQUIPMENT_NAME);
		
		verify(inspectionRepository,times(1)).findByNameOrderByVerificationDetailsInspectionResultSeverityDesc(VALID_EQUIPMENT_NAME);
		assertEquals(inspectionList, list);
	}
	
	@Test
	public void givenInvalidEquipmentName_whenGetAllInspections_ThenShouldThrowNoSuchInspectionException() {
		when(inspectionRepository.findByNameOrderByVerificationDetailsInspectionResultSeverityDesc(INVALID_EQUIPMENT_NAME)).thenReturn(Collections.emptyList());

		try {
			inspectionService.getAllInspections(INVALID_EQUIPMENT_NAME);
			fail();
		} catch (NoSuchInspectionException e) {
			assertEquals(INSPECTION_ERROR_MESSAGE_1, e.getMessage());
			
		}
	}
	
	@Test
	public void givenValidEquipmentName_whenGetRecentInspection_thenShouldReturnTheMostRecentInspection() throws NoSuchInspectionException {
		when(inspectionRepository.findFirstByNameOrderByDateTimeDateDescDateTimeTimeDesc(VALID_EQUIPMENT_NAME)).thenReturn(Optional.of(inspection));
		
		Inspection savedInspection = inspectionService.getRecentInspection(VALID_EQUIPMENT_NAME);
		
		verify(inspectionRepository,times(1)).findFirstByNameOrderByDateTimeDateDescDateTimeTimeDesc(VALID_EQUIPMENT_NAME);
		assertEquals(inspection, savedInspection);
	}
	
	@Test
	public void givenInValidEquipmentName_whenGetRecentInspection_thenShouldThrowNoSuchInspectionException() {
		when(inspectionRepository.findFirstByNameOrderByDateTimeDateDescDateTimeTimeDesc(INVALID_EQUIPMENT_NAME)).thenReturn(Optional.empty());
		
		try {
			inspectionService.getRecentInspection(INVALID_EQUIPMENT_NAME);
			fail();
		} catch (NoSuchInspectionException e) {
			assertEquals(INSPECTION_ERROR_MESSAGE_2, e.getMessage());
		}	
	}
	
	@Test
	public void givenVerificationDetailsWithValidInspectionId_whenAddVerificationDetailsToInspection_thenShouldReturnInspectionWithSavedVerificationDetails()
			throws NoSuchInspectionException {
		when(inspectionRepository.findById(VALID_INSPECTION_ID)).thenReturn(Optional.of(inspection));
		when(inspectionRepository.save(inspection)).thenReturn(inspection);
		
		Inspection savedInspection = inspectionService.addVerificationDetailsToInspection(VALID_INSPECTION_ID, verificationDetails);
		
		verify(inspectionRepository,times(1)).findById(VALID_INSPECTION_ID);
		assertEquals(INSPECTION_RESULT, savedInspection.getVerificationDetails().getInspectionResult());
		assertEquals(ENGINEER_COMMENT, savedInspection.getVerificationDetails().getEngineerComment());
		assertEquals(ENGINEER_ID, savedInspection.getVerificationDetails().getVerifiedBy());

	}
	
	@Test
	public void givenVerificationDetailsWithInValidInspectionId_whenAddVerificationDetailsToInspection_thenShouldThorwNoSuchInspectionException() {
		when(inspectionRepository.findById(INVALID_INSPECTION_ID)).thenReturn(Optional.empty());
		
		try {
			inspectionService.addVerificationDetailsToInspection(INVALID_INSPECTION_ID, verificationDetails);
			fail();
		} catch (NoSuchInspectionException e) {
			assertEquals(INSPECTION_ERROR_MESSAGE_2, e.getMessage());
		}
	}
	
	@Test
	public void givenEquipmentName_whenAddInspection_thenShouldReturnSavedInspectionForThatEquipment() {
		when(inspectionRepository.save(any())).thenReturn(inspection);
		
		Inspection savedInspection = inspectionService.addInspection(VALID_EQUIPMENT_NAME);
		
		verify(inspectionRepository,times(1)).save(any());
		assertEquals(inspection, savedInspection);
	}
	
	@AfterEach
	public void tearDown() {
		inspectionList = Collections.emptyList();
		inspection = null;
		verificationDetails = null;
	}
}
