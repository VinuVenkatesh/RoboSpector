package com.robospector.controller.dto;

public class InspectionDto {

	private String id;
	private String name;
	private DateTimeDto dateTime;
	private int collectingTime;
	private VerificationDetailsDto verificationDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDateTime() {
		this.dateTime = new DateTimeDto();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTimeDto getDateTime() {
		return dateTime;
	}

	public int getCollectingTime() {
		return collectingTime;
	}

	public void setCollectingTime(int collectingTime) {
		this.collectingTime = collectingTime;
	}

	public VerificationDetailsDto getVerificationDetails() {
		return verificationDetails;
	}

	public void setVerificationDetails(VerificationDetailsDto verificationDetails) {
		this.verificationDetails = verificationDetails;
	}
}
