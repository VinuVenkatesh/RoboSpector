package com.robospector.applicationservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robospector.domain.Inspection;
import com.robospector.domain.VerificationDetails;
import com.robospector.repository.InspectionRepository;

@Service
public class InspectionServiceImpl implements InspectionService {

	@Autowired
	InspectionRepository inspectionRepository;
	
	@Override
	public List<Inspection> getAllInspections() {
		
		return inspectionRepository.findAll();
	}

	@Override
	public Inspection getRecentInspection() {
		return inspectionRepository.findFirstByOrderByDateTimeDateDescDateTimeTimeDesc().get();
	}

	@Override
	public Inspection addVerificationDetailsToInspection(String id, VerificationDetails verificationDetails) {
		Optional<Inspection> inspection = inspectionRepository.findById(id);
		if(inspection.isEmpty()) {
			return null;
		}
		else {
			verificationDetails.setVerifiedDate();
			verificationDetails.getVerifiedDate().setDate();
			verificationDetails.getVerifiedDate().setTime();
			inspection.get().setVerificationDetails(verificationDetails);
			return inspectionRepository.save(inspection.get());
		}
	}

	@Override
	public Inspection addInspection() {
		// TODO Auto-generated method stub
		return null;
	}

}
