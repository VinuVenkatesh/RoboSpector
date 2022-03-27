package com.robospector.applicationservice;

import com.robospector.applicationservice.exception.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.exception.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;

public interface LoginService {

	public String authenticateUser(User user) throws UsernameAndPasswordDoNotMatchException, InvalidUserNameOrPasswordServiceException;
}
