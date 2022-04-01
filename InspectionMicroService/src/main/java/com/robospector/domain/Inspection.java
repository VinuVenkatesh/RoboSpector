package com.robospector.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inspectiondetails")
public class Inspection {

	@Id
	private String id;
	private String name;
	private DateTime dateTime;
	private int collectingTime;
	private VerificationDetails verificationDetails;

	public Inspection(String name, int collectingTime, VerificationDetails verificationDetails) {
		super();
		this.name = name;
		this.dateTime = new DateTime();
		this.collectingTime = collectingTime;
		this.verificationDetails = verificationDetails;
	}

	public Inspection() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDateTime() {
		this.dateTime = new DateTime();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public int getCollectingTime() {
		return collectingTime;
	}

	public void setCollectingTime(int collectingTime) {
		this.collectingTime = collectingTime;
	}

	public VerificationDetails getVerificationDetails() {
		return verificationDetails;
	}

	public void setVerificationDetails(VerificationDetails verificationDetails) {
		this.verificationDetails = verificationDetails;
	}

}
