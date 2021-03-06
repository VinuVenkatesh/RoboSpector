package com.robospector.domain;

public class VerificationDetails {

	private String verifiedBy;
	private DateTime verifiedDate;
	private InspectionResult inspectionResult;
	private String engineerComment;

	public VerificationDetails() {
		super();
	}

	public VerificationDetails(String verifiedBy, InspectionResult inspectionResult, String engineerComment) {
		super();
		this.verifiedBy = verifiedBy;
		this.verifiedDate = new DateTime();
		this.inspectionResult = inspectionResult;
		this.engineerComment = engineerComment;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public DateTime getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate() {
		this.verifiedDate = new DateTime();
	}

	public InspectionResult getInspectionResult() {
		return inspectionResult;
	}

	public void setInspectionResult(InspectionResult inspectionResult) {
		this.inspectionResult = inspectionResult;
	}

	public String getEngineerComment() {
		return engineerComment;
	}

	public void setEngineerComment(String engineerComment) {
		this.engineerComment = engineerComment;
	}

}
