package com.robospector.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Equipment not found")
public class EquipmentNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EquipmentNotFoundException(String message) {
		super(message);
	}
}
