package com.robospector.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class InspectionController {

	@Autowired
	private InspectionService inspectionService;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private InspectionResultService inspectionResultControllerService;
	
	@GetMapping("/recent/{equipmentId}")
	public InspectionDto mostRecentInspection(@PathVariable("equipmentId") int equipmentId) {
		try {
			Inspection recentInspection = inspectionService.getRecentInspection(equipmentId);
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

	@PostMapping("/add/{equipmentId}")
	public ResponseEntity<?> createInspection(@PathVariable("equipmentId") int equipmentId) {
		return new ResponseEntity<>(inspectionService.addInspection(equipmentId), HttpStatus.OK);
	}

	@GetMapping("/getall/{equipmentId}")
	public ResponseEntity<?> getAllInspectionsForEquipment(@PathVariable("equipmentId") int equipmentId) {
		try {
			return new ResponseEntity<>(inspectionService.getAllInspections(equipmentId), HttpStatus.OK);
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
	
	@GetMapping("/recent/verified/{equipmentId}")
	public ResponseEntity<?> getMostRecentVerifiedInspection(@PathVariable("equipmentId") int equipmentId){
		Inspection inspection = inspectionService.getMostRecentVerifiedInspection(equipmentId);
		if(inspection == null)
			return new ResponseEntity<>("No verification found", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(inspection, HttpStatus.OK);
	}
}
