package com.robospector.domain;

public class InspectionResult {

	private String name;
	private int severity;

	public InspectionResult() {
		super();
	}

	public InspectionResult(String name, int severity) {
		super();
		this.name = name;
		this.severity = severity;
	}

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
