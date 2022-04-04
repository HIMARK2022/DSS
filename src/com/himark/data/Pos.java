package com.himark.data;

public class Pos {
	private String companyName; // company_name
	private String posId; // pos_id
	private String posName; // pos_name
	
	public Pos() {}

	public Pos(String posId, String posName) {
		super();
		this.posId = posId;
		this.posName = posName;
	}
	
	public Pos(String companyName, String posId, String posName) {
		super();
		this.companyName = companyName;
		this.posId = posId;
		this.posName = posName;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	@Override
	public String toString() {
		return "Pos [companyName=" + companyName + ", posId=" + posId + ", posName=" + posName + "]";
	}
	
}
