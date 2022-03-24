package com.robospector.applicationservice;

public class InvalidUserNameOrPasswordServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidUserNameOrPasswordServiceException(String message) {
		super(message);
	}

}
