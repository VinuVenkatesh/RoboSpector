package com.robospector.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.robospector.controller.dto.InspectionDto;

@FeignClient(name =  "INSPECTION-SERVICE")
public interface InspectionService {

	@PostMapping("/add/{name}")
	public ResponseEntity<?> createInspection(@PathVariable("name") String name);
	
	@GetMapping("/getall/{name}")
	public ResponseEntity<?> getAllInspectionsForEquipment(@PathVariable("name") String name);
	
	@GetMapping("/recent/{name}")
	public InspectionDto mostRecentInspection(@PathVariable("name") String name);
}
