package com.himark.data;

public class Duty {
	private String companyName; // company_name
	private String dutyId; // duty_id
	private String dutyName; // duty_name
	
	public Duty() {}
		
	public Duty(String dutyId, String dutyName) {
		super();
		this.dutyId = dutyId;
		this.dutyName = dutyName;
	}
	
	public Duty(String companyName, String dutyId, String dutyName) {
		super();
		this.companyName = companyName;
		this.dutyId = dutyId;
		this.dutyName = dutyName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	@Override
	public String toString() {
		return "Duty [companyName=" + companyName + ", dutyId=" + dutyId + ", dutyName=" + dutyName + "]";
	}

}