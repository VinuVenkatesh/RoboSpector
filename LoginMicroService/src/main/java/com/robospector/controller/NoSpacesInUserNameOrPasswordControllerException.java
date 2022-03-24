package com.robospector.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "No Spaces Allowed in Username or Password")
public class NoSpacesInUserNameOrPasswordControllerException extends Exception{

	private static final long serialVersionUID = 1L;

}
