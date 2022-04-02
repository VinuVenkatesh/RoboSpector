package com.robospector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robospector.applicationservice.InspectionResultService;

@RestController
public class InspectionResultController {

	@Autowired
	private InspectionResultService inspectionResultService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getListOfInspectionResults(){
		return new ResponseEntity<>(inspectionResultService.getInspectionResults(),HttpStatus.OK);
	}
}
