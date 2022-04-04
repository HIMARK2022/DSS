package com.himark.data;

public class Dept {
	private String companyName; // company_name
	private String deptId; // dept_id
	private String deptName; // dept_name
	private String upperDeptId; // upper_dept_id
	
	public Dept() {}

	public Dept(String deptId, String deptName, String upperDeptId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.upperDeptId = upperDeptId;
	}
	
	public Dept(String companyName, String deptId, String deptName, String upperDeptId) {
		super();
		this.companyName = companyName;
		this.deptId = deptId;
		this.deptName = deptName;
		this.upperDeptId = upperDeptId;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUpperDeptId() {
		return upperDeptId;
	}

	public void setUpperDeptId(String upperDeptId) {
		this.upperDeptId = upperDeptId;
	}

	@Override
	public String toString() {
		return "Dept [companyName=" + companyName + ", deptId=" + deptId + ", deptName=" + deptName + ", upperDeptId="
				+ upperDeptId + "]";
	}
	
}
