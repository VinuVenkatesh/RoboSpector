package com.robospector.applicationservice;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.robospector.applicationservice.exception.InvalidUserNameOrPasswordServiceException;
import com.robospector.applicationservice.exception.UsernameAndPasswordDoNotMatchException;
import com.robospector.domain.User;
import com.robospector.repository.LoginRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginServiceImpl implements LoginService {

	@Value("${jwt.secret}")
	private String key;
	
	@Autowired
	private LoginRepository repository;

	@Autowired
	@Qualifier("loginCredentialsValidatorForService")
	private LoginCredentialsValidatorForService credentialsValidatorForService;

	@Override
	public User authenticateUser(User user)
			throws InvalidUserNameOrPasswordServiceException, UsernameAndPasswordDoNotMatchException {
		credentialsValidatorForService.validate(user.getUsername());
		credentialsValidatorForService.validate(user.getPassword());
		Optional<User> savedUser = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		credentialsValidatorForService.validateIfUserExists(savedUser);
		return savedUser.get();
	}

	@Override
	public String generateJwtToken(String username) {
		return Jwts.builder().setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 100000000))
				.signWith(SignatureAlgorithm.HS256, key)
				.compact();
	}
}
