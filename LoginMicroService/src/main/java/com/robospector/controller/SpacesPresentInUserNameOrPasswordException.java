package com.robospector.controller;

public class SpacesPresentInUserNameOrPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public SpacesPresentInUserNameOrPasswordException(String message) {
		super(message);
	}
}
