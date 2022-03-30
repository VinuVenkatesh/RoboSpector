package com.robospector.applicationservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robospector.applicationservice.exception.NoSuchInspectionException;
import com.robospector.domain.Inspection;
import com.robospector.domain.VerificationDetails;
import com.robospector.repository.InspectionRepository;

@Service
public class InspectionServiceImpl implements InspectionService {

	@Autowired
	RandomInspectionDetailsGenerator dateTimeGenerator;
	
	@Autowired
	InspectionRepository inspectionRepository;
	
	@Override
	public List<Inspection> getAllInspections(String name) throws NoSuchInspectionException {
		List<Inspection> list = inspectionRepository.findByNameOrderByVerificationDetailsInspectionResultSeverityDesc(name);
		if(list.isEmpty()) {
			throw new NoSuchInspectionException("No inspections exist for this equipment");
		}
		return list;
	}

	@Override
	public Inspection getRecentInspection(String name) throws NoSuchInspectionException {
		Optional<Inspection> optional = inspectionRepository.findFirstByNameOrderByDateTimeDateDescDateTimeTimeDesc(name);
		if(optional.isEmpty()) {
			throw new NoSuchInspectionException("The inspection does not exist");
		}
		return optional.get();
	}

	@Override
	public Inspection addVerificationDetailsToInspection(String id, VerificationDetails verificationDetails) throws NoSuchInspectionException {
		Optional<Inspection> inspection = inspectionRepository.findById(id);
		if(inspection.isEmpty()) {
			throw new NoSuchInspectionException("The inspection does not exist");
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
	public Inspection addInspection(String name) {
		Inspection inspection = new Inspection();
		inspection.setDateTime();
		inspection.getDateTime().setRandomDate(dateTimeGenerator.createRandomDate());
		inspection.getDateTime().setRandomTime(dateTimeGenerator.createRandomTime());
		inspection.setCollectingTime(dateTimeGenerator.createRandomCollectingTime());
		inspection.setName(name);
		return inspectionRepository.save(inspection);
	}

	@Override
	public void deleteInspections(String name) throws NoSuchInspectionException {
		List<Inspection> list = inspectionRepository.findByNameOrderByVerificationDetailsInspectionResultSeverityDesc(name);
		if(list.isEmpty()) {
			throw new NoSuchInspectionException("No inspections exist for this equipment");
		}
		inspectionRepository.deleteAll(list);
	}

}
