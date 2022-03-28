package com.robospector.applicationservice;

import com.robospector.applicationservice.exception.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.exception.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;

public interface LoginService {

	public void authenticateUser(User user)
			throws UsernameAndPasswordDoNotMatchException, InvalidUserNameOrPasswordServiceException;
	public String generateJwtToken(String username);
}
