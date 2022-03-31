package com.robospector.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robospector.applicationService.EquipmentService;
import com.robospector.domain.PieceOfEquipment;

@RestController
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/")
	public ResponseEntity<?> heartbeatTest() {
		return new ResponseEntity<>("Equipment service is alive", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEquipment() {
		System.out.println("==========================================================================");
		System.out.println("Got here: getAll");
		System.out.println("==========================================================================");
		List<PieceOfEquipment> equipmentRetrieved = equipmentService.getAllEquipemt();
		
		if(equipmentRetrieved.isEmpty()) {
			return new ResponseEntity<>("No equipment found", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(equipmentRetrieved, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createPieceOfEquipment(@RequestBody PieceOfEquipmentDto pieceOfEquipmentDto) {
		System.out.println("==========================================================================");
		System.out.println("Got here: create");
		System.out.println("==========================================================================");
		PieceOfEquipment pieceOfEquipement = mapper.map(pieceOfEquipmentDto, PieceOfEquipment.class);
		PieceOfEquipment pieceOfEquipmentRetrieved = equipmentService.createPieceOfEquipment(pieceOfEquipement);
		
		if(pieceOfEquipmentRetrieved == null) {
			return new ResponseEntity<>("Could not create equipement", HttpStatus.BAD_REQUEST);
		}
		
		//return new ResponseEntity<>("Got here", HttpStatus.OK);
		return new ResponseEntity<>(pieceOfEquipmentRetrieved, HttpStatus.OK);
	}
}
