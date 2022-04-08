package com.robospector.applicationservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robospector.domain.InspectionResult;
import com.robospector.repository.InspectionResultRepository;

@Service
public class InspectionResultServiceImpl implements InspectionResultService {

	@Autowired
	InspectionResultRepository inspectionResultRepository;
	
	@Override
	public List<InspectionResult> getInspectionResults() {
		
		List<InspectionResult> inspectionResultList = inspectionResultRepository.findAll();
		return inspectionResultList;
	}

}
