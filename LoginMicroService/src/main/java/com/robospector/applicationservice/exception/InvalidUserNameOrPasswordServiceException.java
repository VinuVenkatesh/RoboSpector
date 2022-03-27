package com.robospector.applicationservice.exception;

public class InvalidUserNameOrPasswordServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidUserNameOrPasswordServiceException(String message) {
		super(message);
	}
}
