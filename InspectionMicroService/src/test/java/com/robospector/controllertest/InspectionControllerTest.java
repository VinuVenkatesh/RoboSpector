package com.robospector.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.robospector.applicationservice.InspectionService;
import com.robospector.applicationservice.RandomInspectionDetailsGenerator;
import com.robospector.applicationservice.exception.NoSuchInspectionException;
import com.robospector.controller.InspectionController;
import com.robospector.domain.Inspection;
import com.robospector.domain.InspectionResult;
import com.robospector.domain.VerificationDetails;

@AutoConfigureMockMvc
public class InspectionControllerTest {
	
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

	private List<Inspection> inspectionList;
	private Inspection inspection;
	private VerificationDetails verificationDetails;
	private MockMvc mockMvc;
	
	@Mock
	private RandomInspectionDetailsGenerator detailsGenerator;
	
	@Mock
	private InspectionService inspectionService;
	
	@InjectMocks
	private InspectionController inspectionController;
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(inspectionController).build();
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
	public void givenValidEquipmentName_whenMostRecentInspection_thenShouldReturnMostRecentInspectionWithStatusOk()
			throws Exception {
		when(inspectionService.getRecentInspection(VALID_EQUIPMENT_NAME)).thenReturn(inspection);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/recent/" + VALID_EQUIPMENT_NAME)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidEquipmentName_whenMostRecentInspection_thenShouldErrorMessageWithStatusNotFound()
			throws Exception {
		doThrow(NoSuchInspectionException.class).when(inspectionService).getRecentInspection(INVALID_EQUIPMENT_NAME);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/recent/" + INVALID_EQUIPMENT_NAME)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenValidInspectionIdAndVerificationDetails_whenAddVerificationDetails_thenShouldReturnInspectionWithStatusOk()
			throws Exception {
		when(inspectionService.addVerificationDetailsToInspection(VALID_INSPECTION_ID, verificationDetails)).thenReturn(inspection);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/verify/" + VALID_INSPECTION_ID)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(verificationDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void givenInvalidInspectionIdAndVerificationDetails_whenAddVerificationDetails_thenShouldReturnInspectionWithStatusNotFound()
			throws Exception {
		doThrow(NoSuchInspectionException.class).when(inspectionService).addVerificationDetailsToInspection(any(), any());

		mockMvc.perform(MockMvcRequestBuilders.put("/verify/" + INVALID_INSPECTION_ID)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(verificationDetails)))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenEquipmentNameToAdd_whenCreateInspection_thenShouldReturnAddedWithStatusOk()
			throws Exception {
		when(inspectionService.addInspection(VALID_EQUIPMENT_NAME)).thenReturn(inspection);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/add/" + VALID_EQUIPMENT_NAME)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenValidEquipmentName_whenGetAllInspectionsForEquipment_thenShouldReturnListOfInspections()
			throws Exception {
		when(inspectionService.getAllInspections(VALID_EQUIPMENT_NAME)).thenReturn(inspectionList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getall/" + VALID_EQUIPMENT_NAME)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidEquipmentName_whenGetAllInspectionsForEquipment_thenShouldReturnErrorMessageWithStatusNotFound()
			throws Exception {
		doThrow(NoSuchInspectionException.class).when(inspectionService).getAllInspections(any());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getall/" + INVALID_EQUIPMENT_NAME)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenValidEquipmentName_whenDeleteAllInspectionsForEquipment_thenShouldReturnStatusOk()
			throws Exception {
		doNothing().when(inspectionService).deleteInspections(VALID_EQUIPMENT_NAME);
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteall/" + VALID_EQUIPMENT_NAME)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void givenInvalidEquipmentName_whenDeleteAllInspectionsForEquipment_thenShouldThrowNoSuchInspectionException()
			throws Exception {
		doThrow(NoSuchInspectionException.class).when(inspectionService).deleteInspections(any());
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteall/" + VALID_EQUIPMENT_NAME)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
	}
	
	private static String asJsonString(final Object obj) {
        try {
        	ObjectMapper objmapper = new ObjectMapper();
        	objmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        	objmapper.registerModule(new JavaTimeModule());
            return objmapper.writeValueAsString(obj);
           } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	@AfterEach
	public void tearDown() {
		inspectionList = Collections.emptyList();
		inspection = null;
		verificationDetails = null;
	}
}