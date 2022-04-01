package com.robospector.controllertest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.robospector.applicationservice.InspectionResultService;
import com.robospector.controller.InspectionResultController;
import com.robospector.domain.InspectionResult;

public class InspectionResultControllerTest {

	private List<InspectionResult> inspectionResultList;
	
	@Mock
	private InspectionResultService inspectionResultService;
	
	@InjectMocks
	private InspectionResultController inspectionResultController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(inspectionResultController).build();
		inspectionResultList = new ArrayList<InspectionResult>();
		inspectionResultList.add(new InspectionResult(1,"911 immediate assistance required",99));
		inspectionResultList.add(new InspectionResult(2,"Acceptable",1));
		inspectionResultList.add(new InspectionResult(3,"Minor wear",2));
		inspectionResultList.add(new InspectionResult(4,"Major wear",3));
		inspectionResultList.add(new InspectionResult(5,"On-site inspection required",4));
	}
	
	@Test
	public void givenGetRequestForListOfInspectionResults_whenGetListOfInspectionResults_thenShouldReturnListOfInspectionResults() throws Exception {
		Mockito.when(inspectionResultService.getInspectionResults()).thenReturn(inspectionResultList);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/list")
				.contentType(MediaType.APPLICATION_JSON))
         		.andExpect(MockMvcResultMatchers.status().isOk())
         		.andDo(MockMvcResultHandlers.print());
	}
}
