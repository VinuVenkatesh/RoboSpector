package com.robospector.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robospector.domain.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUsernameAndPassword(String username, String password);
}
