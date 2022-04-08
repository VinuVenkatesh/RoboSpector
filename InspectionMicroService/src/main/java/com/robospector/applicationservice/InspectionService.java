package com.robospector.applicationservice;

import java.util.List;

import com.robospector.applicationservice.exception.NoSuchInspectionException;
import com.robospector.domain.Inspection;
import com.robospector.domain.VerificationDetails;

public interface InspectionService {

	public List<Inspection> getAllInspections(int equipmentId) throws NoSuchInspectionException;

	public Inspection getRecentInspection(int equipmentId) throws NoSuchInspectionException;

	public Inspection addVerificationDetailsToInspection(String id, VerificationDetails verificationDetails) throws NoSuchInspectionException;
	
	public Inspection addInspection(int equipmentId);
	
	//public void deleteInspections(String name) throws NoSuchInspectionException;
	
	public Inspection getMostRecentVerifiedInspection(int equipmentId);
}
