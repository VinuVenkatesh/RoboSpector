package com.robospector.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "INSPECTIONRESULT-MICROSERVICE")
public interface InspectionResultService {

	@GetMapping("/list")
	public ResponseEntity<?> getListOfInspectionResults();
}
