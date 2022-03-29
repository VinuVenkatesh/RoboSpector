package com.robospector.applicationservice;

import java.util.List;

import com.robospector.domain.Inspection;
import com.robospector.domain.VerificationDetails;

public interface InspectionService {

	public List<Inspection> getAllInspections();

	public Inspection getRecentInspection();

	public Inspection addVerificationDetailsToInspection(String name, VerificationDetails verificationDetails);
	
	public Inspection addInspection();
}
