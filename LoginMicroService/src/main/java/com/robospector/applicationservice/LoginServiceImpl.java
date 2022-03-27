package com.robospector.applicationservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.robospector.applicationservice.exception.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.exception.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;
import com.robospector.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository repository;

	@Autowired
	@Qualifier("loginCredentialsValidatorForService")
	private LoginCredentialsValidatorForService credentialsValidatorForService;

	@Override
	public String authenticateUser(User user)
			throws InvalidUserNameOrPasswordServiceException, UsernameAndPasswordDoNotMatchException {
		credentialsValidatorForService.validate(user.getUsername());
		credentialsValidatorForService.validate(user.getPassword());
		Optional<User> savedUser = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		credentialsValidatorForService.isEmpty(savedUser);
		return savedUser.get().getRole();
	}
}
