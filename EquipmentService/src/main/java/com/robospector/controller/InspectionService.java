package com.robospector.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.robospector.controller.dto.InspectionDto;

@FeignClient(name =  "INSPECTION-SERVICE")
public interface InspectionService {

	@PostMapping("/add/{equipmentId}")
	public ResponseEntity<?> createInspection(@PathVariable("equipmentId") int equipmentId);
	
	@GetMapping("/getall/{equipmentId}")
	public ResponseEntity<?> getAllInspectionsForEquipment(@PathVariable("equipmentId") int equipmentId);
	
	@GetMapping("/recent/{equipmentId}")
	public InspectionDto mostRecentInspection(@PathVariable("equipmentId") int equipmentId);
}
