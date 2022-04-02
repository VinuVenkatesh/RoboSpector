package com.robospector.controller.dto;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.robospector.domain.DateTime;
import com.robospector.domain.VerificationDetails;

@Component
public class InspectionDto {

	@Id
	private String id;
	private int equipmentId;
	private DateTime dateTime;
	private int collectingTime;
	private VerificationDetails verificationDetails;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
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
