package com.robospector.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robospector.applicationService.EquipmentService;
import com.robospector.controller.dto.PieceOfEquipmentDto;
import com.robospector.controller.exception.EquipmentNotFoundException;
import com.robospector.controller.exception.InvalidInputException;
import com.robospector.domain.PieceOfEquipment;

@RestController
public class EquipmentController {
	
	@Autowired
	private PieceOfEquipmentDtoValidator pieceOfEquipmentDtoValidator;

	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/")
	public ResponseEntity<?> heartbeatTest() {
		return new ResponseEntity<>("Equipment service is alive", HttpStatus.OK);
	}

	// Todo: I need to sort the data sent. By what?
	
	@PostMapping("/create")
	public ResponseEntity<?> createPieceOfEquipment(@RequestBody PieceOfEquipmentDto pieceOfEquipmentDto)
			throws InvalidInputException {
		pieceOfEquipmentDtoValidator.validate(pieceOfEquipmentDto);
		
		PieceOfEquipment pieceOfEquipement = mapper.map(pieceOfEquipmentDto, PieceOfEquipment.class);
		PieceOfEquipment pieceOfEquipmentCreated = equipmentService.createPieceOfEquipment(pieceOfEquipement);
		
		if(pieceOfEquipmentCreated == null) {
			return new ResponseEntity<>("Could not create equipement", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(pieceOfEquipmentCreated, HttpStatus.OK);
	}

	@GetMapping("/find/{name_pattern}")
	public ResponseEntity<?>getEquipmentWithNamePattern(@PathVariable("name_pattern") String namePattern) {
		List<PieceOfEquipment> equipmentRetrieved = equipmentService.findEquipmentWithNamePattern(namePattern);
		
		if(equipmentRetrieved.isEmpty()) {
			return new ResponseEntity<>("No equipment found", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(equipmentRetrieved, HttpStatus.OK);
	}
	
	@PutMapping("/update/{equipment_id}")
	public ResponseEntity<?>updatePieceOfEquipment(@PathVariable("equipment_id")  int equipmentId,
			@RequestBody PieceOfEquipmentDto pieceOfEquipmentDto) throws EquipmentNotFoundException {
		PieceOfEquipment pieceOfEquipmentToUpdate = mapper.map(pieceOfEquipmentDto, PieceOfEquipment.class);
		
		PieceOfEquipment pieceOfEquipmentUpdated =
				equipmentService.updatePieceOfEquipment(equipmentId, pieceOfEquipmentToUpdate);
		return new ResponseEntity<>(pieceOfEquipmentUpdated, HttpStatus.OK);
	}
	
	@PutMapping("/delete/{equipment_id}")
	public ResponseEntity<?>softDeletePieceOfEquipment(@PathVariable("equipment_id")  int equipmentId) throws EquipmentNotFoundException {
		PieceOfEquipment archivedEquipment = equipmentService.makeArchived(equipmentId);
		return new ResponseEntity<>(archivedEquipment, HttpStatus.OK);
	}
	
	// Todo: Undo delete (We might need a Stack data structure)
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEquipment() { // Use mapper here------- Also call other services to get data
		List<PieceOfEquipment> equipmentRetrieved = equipmentService.getAllEquipemt();
		
		if(equipmentRetrieved.isEmpty()) {
			return new ResponseEntity<>("No equipment found", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(equipmentRetrieved, HttpStatus.OK);
	}
}
