package com.robospector.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robospector.applicationservice.InspectionService;
import com.robospector.applicationservice.exception.NoSuchInspectionException;
import com.robospector.controller.dto.InspectionDto;
import com.robospector.domain.Inspection;
import com.robospector.domain.VerificationDetails;

@RestController
public class InspectionController {

	@Autowired
	private InspectionService inspectionService;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private InspectionResultService inspectionResultControllerService;
	
	@GetMapping("/recent/{name}")
	public InspectionDto mostRecentInspection(@PathVariable("name") String name) {
		try {
			Inspection recentInspection = inspectionService.getRecentInspection(name);
			InspectionDto inspectionDto = mapper.map(recentInspection, InspectionDto.class);
			return inspectionDto;
		} catch (NoSuchInspectionException e) {
			return null;
		}
	}

	@PutMapping("/verify/{id}")
	public ResponseEntity<?> addVerificationDetails(@PathVariable("id") String id,
			@RequestBody VerificationDetails verificationDetails) {
		try {
			Inspection obj = inspectionService.addVerificationDetailsToInspection(id, verificationDetails);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (NoSuchInspectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add/{name}")
	public ResponseEntity<?> createInspection(@PathVariable("name") String name) {
		return new ResponseEntity<>(inspectionService.addInspection(name), HttpStatus.OK);
	}

	@GetMapping("/getall/{name}")
	public ResponseEntity<?> getAllInspectionsForEquipment(@PathVariable("name") String name) {
		try {
			return new ResponseEntity<>(inspectionService.getAllInspections(name), HttpStatus.OK);
		} catch (NoSuchInspectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

//	@DeleteMapping("/deleteall/{name}")
//	public ResponseEntity<?> deleteAllInspectionsForEquipment(@PathVariable("name") String name) {
//		try {
//			inspectionService.deleteInspections(name);
//			return new ResponseEntity<>("Deleted sucessfully", HttpStatus.OK);
//		} catch (NoSuchInspectionException e) {
//			// TODO Auto-generated catch block
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping("/inspectionresults")
	public ResponseEntity<?> getAllInspectionResults(){
		return new ResponseEntity<>(inspectionResultControllerService.getListOfInspectionResults().getBody(),HttpStatus.OK);
	}
}
