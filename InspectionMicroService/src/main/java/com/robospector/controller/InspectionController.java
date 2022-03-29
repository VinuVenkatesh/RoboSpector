package com.robospector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robospector.applicationservice.InspectionService;
import com.robospector.domain.Inspection;
import com.robospector.domain.VerificationDetails;

@RestController
public class InspectionController {

	@Autowired
	InspectionService inspectionService;
	
	@GetMapping("/recent")
	public ResponseEntity<?> mostRecentInspection(){
		return new ResponseEntity<>(inspectionService.getRecentInspection(),HttpStatus.OK);
	}
	
	@PutMapping("/add/{id}")
	public ResponseEntity<?> addVerificationDetails(@PathVariable("id") String name, @RequestBody VerificationDetails verificationDetails){
		Inspection obj = inspectionService.addVerificationDetailsToInspection(name, verificationDetails);
		if(obj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(obj, HttpStatus.OK);
		}
	}
}
