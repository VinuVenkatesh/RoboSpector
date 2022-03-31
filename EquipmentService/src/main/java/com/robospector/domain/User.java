package com.robospector.domain;

public class User {

	private boolean isAllowedToCreate = false;

	public boolean isAllowedToCreate() {
		return isAllowedToCreate;
	}

	public void grantCreationPermission(boolean isAllowedToCreate) {
		this.isAllowedToCreate = isAllowedToCreate;
	}

	public boolean hasCreationPermission() {
		return isAllowedToCreate;
	}
	
	
}
