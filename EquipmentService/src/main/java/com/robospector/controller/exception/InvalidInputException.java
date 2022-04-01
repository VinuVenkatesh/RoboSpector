package com.robospector.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid input")
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String message) {
		super(message);
	}	
}
