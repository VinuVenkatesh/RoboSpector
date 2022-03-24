package com.robospector.applicationservice;



public class UsernameAndPasswordDoNotMatchException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UsernameAndPasswordDoNotMatchException(String message) {
		super(message);
	}
	
}
