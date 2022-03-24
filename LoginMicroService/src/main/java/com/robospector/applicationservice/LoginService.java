package com.robospector.applicationservice;

import com.robospector.domain.User;

public interface LoginService {

	public String userAuthentication(User user) throws UsernameAndPasswordDoNotMatchException, InvalidUserNameOrPasswordServiceException;
}
