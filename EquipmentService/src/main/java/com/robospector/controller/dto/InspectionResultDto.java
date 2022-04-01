package com.robospector.controller.dto;

public class InspectionResultDto {

	private String name;
	private int severity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}
}
