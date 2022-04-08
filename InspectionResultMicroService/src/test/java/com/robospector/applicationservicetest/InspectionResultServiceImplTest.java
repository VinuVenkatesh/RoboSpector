package com.robospector.applicationservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.robospector.applicationservice.InspectionResultServiceImpl;
import com.robospector.domain.InspectionResult;
import com.robospector.repository.InspectionResultRepository;

public class InspectionResultServiceImplTest {

	@Mock
	private InspectionResultRepository inspectionResultRepository;
	
	@InjectMocks
	private InspectionResultServiceImpl inspectionResultService;
	
	private List<InspectionResult> inspectionResultList;
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		inspectionResultList = new ArrayList<InspectionResult>();
		inspectionResultList.add(new InspectionResult(1,"911 immediate assistance required",99));
		inspectionResultList.add(new InspectionResult(2,"Acceptable",1));
		inspectionResultList.add(new InspectionResult(3,"Minor wear",2));
		inspectionResultList.add(new InspectionResult(4,"Major wear",3));
		inspectionResultList.add(new InspectionResult(5,"On-site inspection required",4));
	}
	
	@Test
	public void givenRequestForListOfInspectionResults_whengetInspectionResults_thenShouldReturnListOfInspectionResults() {
		when(inspectionResultRepository.findAll()).thenReturn(inspectionResultList);
		
		List<InspectionResult> savedInspectionResultList = inspectionResultService.getInspectionResults();
		
		verify(inspectionResultRepository, times(1)).findAll();
		assertEquals(inspectionResultList, savedInspectionResultList);
	}
}
