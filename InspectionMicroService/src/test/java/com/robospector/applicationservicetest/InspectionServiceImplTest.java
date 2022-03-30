package com.robospector.applicationservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
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
import com.robospector.repository.InspectionRepository;

public class InspectionServiceImplTest {

	private static final String VALID_EQUIPMENT_NAME = "test";
	private static final String INVALID_EQUIPMENT_NAME = "test123";
	private static final String INSPECTION_ERROR_MESSAGE_1 = "No inspections exist for this equipment";
	private static final String INSPECTION_ERROR_MESSAGE_2 = "The inspection does not exist";
	
	@Mock
	private InspectionRepository inspectionRepository;
	
	@Mock
	private RandomInspectionDetailsGenerator detailsGenerator;
	
	private List<Inspection> inspectionList;
	private Inspection inspection;
	
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
		obj.setCollectingTime(detailsGenerator.createRandomCollectingTime());
		obj.setDateTime();
		obj.getDateTime().setRandomDate(detailsGenerator.createRandomDate());
		obj.getDateTime().setRandomTime(detailsGenerator.createRandomTime());
		obj.setName(VALID_EQUIPMENT_NAME);
		inspectionList.add(obj);
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
			List<Inspection> list = inspectionService.getAllInspections(INVALID_EQUIPMENT_NAME);
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
	public void givenInValidEquipmentName_whenGetRecentInspection_thenShouldReturnTheMostRecentInspection() {
		when(inspectionRepository.findFirstByNameOrderByDateTimeDateDescDateTimeTimeDesc(INVALID_EQUIPMENT_NAME)).thenReturn(Optional.empty());
		
		try {
			Inspection savedInspection = inspectionService.getRecentInspection(INVALID_EQUIPMENT_NAME);
		} catch (NoSuchInspectionException e) {
			assertEquals(INSPECTION_ERROR_MESSAGE_2, e.getMessage());
		}	
	}
	
	@AfterEach
	public void tearDown() {
		inspectionList = Collections.emptyList();
		inspection = null;
	}
}
