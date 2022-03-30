package com.robospector.applicationservice;

import java.util.List;

import com.robospector.applicationservice.exception.NoSuchInspectionException;
import com.robospector.domain.Inspection;
import com.robospector.domain.VerificationDetails;

public interface InspectionService {

	public List<Inspection> getAllInspections(String name) throws NoSuchInspectionException;

	public Inspection getRecentInspection(String name) throws NoSuchInspectionException;

	public Inspection addVerificationDetailsToInspection(String name, VerificationDetails verificationDetails) throws NoSuchInspectionException;
	
	public Inspection addInspection(String name);
	
	public void deleteInspections(String name) throws NoSuchInspectionException;
}
