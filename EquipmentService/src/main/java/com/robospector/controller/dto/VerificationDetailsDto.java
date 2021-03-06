package com.robospector.controller.dto;

public class VerificationDetailsDto {

	private String verifiedBy;
	private DateTimeDto verifiedDate;
	private InspectionResultDto inspectionResult;
	private String engineerComment;

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public DateTimeDto getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate() {
		this.verifiedDate = new DateTimeDto();
	}

	public InspectionResultDto getInspectionResult() {
		return inspectionResult;
	}

	public void setInspectionResult(InspectionResultDto inspectionResult) {
		this.inspectionResult = inspectionResult;
	}

	public String getEngineerComment() {
		return engineerComment;
	}

	public void setEngineerComment(String engineerComment) {
		this.engineerComment = engineerComment;
	}
}
