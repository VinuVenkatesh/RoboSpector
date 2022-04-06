package com.robospector.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
import org.modelmapper.ModelMapper;
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
import com.robospector.controller.InspectionResultService;
import com.robospector.controller.dto.InspectionDto;
import com.robospector.domain.Inspection;
import com.robospector.domain.InspectionResult;
import com.robospector.domain.VerificationDetails;

@AutoConfigureMockMvc
public class InspectionControllerTest {
	
	private static final int VALID_EQUIPMENT_ID = 1;
	private static final int INVALID_EQUIPMENT_ID = 10;
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
	private InspectionDto inspectionDto;
	
	@Mock
	private RandomInspectionDetailsGenerator detailsGenerator;
	
	@Mock
	private InspectionService inspectionService;
	
	@Mock
	private ModelMapper mapper;
	
	@InjectMocks
	private InspectionController inspectionController;
	
	@Mock
	private InspectionResultService inspectionResultService;
	
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
		obj.setEquipmentId(VALID_EQUIPMENT_ID);
		inspectionList.add(obj);
		inspection = obj;
		inspection.setId(VALID_INSPECTION_ID);
		obj.setCollectingTime(detailsGenerator.createRandomCollectingTime());
		obj.setDateTime();
		obj.getDateTime().setRandomDate(detailsGenerator.createRandomDate());
		obj.getDateTime().setRandomTime(detailsGenerator.createRandomTime());
		obj.setEquipmentId(VALID_EQUIPMENT_ID);
		inspectionList.add(obj);
		verificationDetails = new VerificationDetails();
		verificationDetails.setEngineerComment(ENGINEER_COMMENT);
		verificationDetails.setVerifiedBy(ENGINEER_ID);
		INSPECTION_RESULT.setName(NAME);
		INSPECTION_RESULT.setSeverity(SEVERITY);
		verificationDetails.setInspectionResult(INSPECTION_RESULT);
		inspection.setVerificationDetails(verificationDetails);
		inspectionDto.setCollectingTime(inspection.getCollectingTime());
		inspectionDto.setDateTime(inspection.getDateTime());
		inspectionDto.setEquipmentId(inspection.getEquipmentId());
		inspectionDto.setId(inspection.getId());
		inspectionDto.setVerificationDetails(inspection.getVerificationDetails());
	}
	
	
	@Test
	public void givenValidEquipmentName_whenMostRecentInspection_thenShouldReturnMostRecentInspectionWithStatusOk()
			throws Exception {
		when(inspectionService.getRecentInspection(VALID_EQUIPMENT_ID)).thenReturn(inspection);
		when(mapper.map(inspection, InspectionDto.class)).thenReturn(inspectionDto);
		
		InspectionDto recentInspection = inspectionController.mostRecentInspection(VALID_EQUIPMENT_ID);
	
		assertEquals(inspectionDto, recentInspection);
	}
	
	
	@Test
	public void givenInvalidEquipmentName_whenMostRecentInspection_thenShouldErrorMessageWithStatusNotFound()
			throws Exception {
		when(inspectionService.getRecentInspection(INVALID_EQUIPMENT_ID)).thenThrow(new NoSuchInspectionException(""));
		when(mapper.map(inspection, InspectionDto.class)).thenReturn(null);
		
		InspectionDto recentInspection = inspectionController.mostRecentInspection(INVALID_EQUIPMENT_ID);
	
		assertEquals(null, recentInspection);
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
		when(inspectionService.addInspection(VALID_EQUIPMENT_ID)).thenReturn(inspection);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/add/" + VALID_EQUIPMENT_ID)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	}
	

	@Test
	public void givenValidEquipmentName_whenGetAllInspectionsForEquipment_thenShouldReturnListOfInspections()
			throws Exception {
		when(inspectionService.getAllInspections(VALID_EQUIPMENT_ID)).thenReturn(inspectionList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getall/" + VALID_EQUIPMENT_ID)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
	}

	
	
	@Test
	public void givenInvalidEquipmentName_whenGetAllInspectionsForEquipment_thenShouldReturnErrorMessageWithStatusNotFound()
			throws Exception {
		doThrow(NoSuchInspectionException.class).when(inspectionService).getAllInspections(anyInt());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getall/" + INVALID_EQUIPMENT_ID)
				.contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
	}
	

	
//	@Test
//	public void givenValidEquipmentName_whenDeleteAllInspectionsForEquipment_thenShouldReturnStatusOk()
//			throws Exception {
//		doNothing().when(inspectionService).deleteInspections(VALID_EQUIPMENT_ID);
//		
//		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteall/" + VALID_EQUIPMENT_ID)
//				.contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//	}
//	
//	@Test
//	public void givenInvalidEquipmentName_whenDeleteAllInspectionsForEquipment_thenShouldThrowNoSuchInspectionException()
//			throws Exception {
//		doThrow(NoSuchInspectionException.class).when(inspectionService).deleteInspections(any());
//		
//		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteall/" + VALID_EQUIPMENT_ID)
//				.contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//	}
	
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
