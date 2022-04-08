package com.robospector.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	private String role;
	
	private String name;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getName() {
		String[]  firstAndLastName= username.split("\\.", 0);
		String firstName = firstAndLastName[0].substring(0, 1).toUpperCase() + firstAndLastName[0].substring(1).toLowerCase();
		String lastName = firstAndLastName[1].substring(0, 1).toUpperCase() + firstAndLastName[1].substring(1).toLowerCase();
		return firstName + " " + lastName;
	}
}
