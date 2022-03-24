package com.robospector.applicationservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.robospector.domain.User;
import com.robospector.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository repository;
	
	@Autowired
	@Qualifier("loginCredentialsValidatorForService")
	private LoginCredentialsValidatorForService credentialsValidatorForService;
	
	@Override
	public String userAuthentication(User user) throws UsernameAndPasswordDoNotMatchException, InvalidUserNameOrPasswordServiceException {
		
		Optional<String> validUser = credentialsValidatorForService.validator(user.getUsername());
		Optional<String> validPassword = credentialsValidatorForService.validator(user.getPassword());
		
		if(!validUser.isEmpty()) {
			throw new InvalidUserNameOrPasswordServiceException(validUser.get());
		}
		else if(!validPassword.isEmpty()) {
			throw new InvalidUserNameOrPasswordServiceException(validPassword.get());
		}
		else {
			Optional<User> savedUser = repository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
			if(savedUser.isEmpty()) {
				throw new UsernameAndPasswordDoNotMatchException("Invalid Username or Password");
			}
			return savedUser.get().getRole();
		}
		
	}

}
