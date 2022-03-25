package com.robospector.applicationservice;

import com.robospector.domain.User;

public interface LoginService {

	public void userAuthentication(User user) throws UsernameAndPasswordDoNotMatchException, InvalidUserNameOrPasswordServiceException;
	public String generateJwtToken(String username);
}
