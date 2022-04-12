package com.himark.data;

public class Info {
	private int userInsertCount;
	private int userUpdateCount;
	private int userDeleteCount;
	private int deptInsertCount;
	private int deptUpdateCount;
	private int deptDeleteCount;
	private String start;
	private String finish;
	
	public Info(int userInsertCount, int userUpdateCount, int userDeleteCount, int deptInsertCount, int deptUpdateCount,
			int deptDeleteCount, String start, String finish) {
		super();
		this.userInsertCount = userInsertCount;
		this.userUpdateCount = userUpdateCount;
		this.userDeleteCount = userDeleteCount;
		this.deptInsertCount = deptInsertCount;
		this.deptUpdateCount = deptUpdateCount;
		this.deptDeleteCount = deptDeleteCount;
		this.start = start;
		this.finish = finish;
	}

	public int getUserInsertCount() {
		return userInsertCount;
	}

	public void setUserInsertCount(int userInsertCount) {
		this.userInsertCount = userInsertCount;
	}

	public int getUserUpdateCount() {
		return userUpdateCount;
	}

	public void setUserUpdateCount(int userUpdateCount) {
		this.userUpdateCount = userUpdateCount;
	}

	public int getUserDeleteCount() {
		return userDeleteCount;
	}

	public void setUserDeleteCount(int userDeleteCount) {
		this.userDeleteCount = userDeleteCount;
	}

	public int getDeptInsertCount() {
		return deptInsertCount;
	}

	public void setDeptInsertCount(int deptInsertCount) {
		this.deptInsertCount = deptInsertCount;
	}

	public int getDeptUpdateCount() {
		return deptUpdateCount;
	}

	public void setDeptUpdateCount(int deptUpdateCount) {
		this.deptUpdateCount = deptUpdateCount;
	}

	public int getDeptDeleteCount() {
		return deptDeleteCount;
	}

	public void setDeptDeleteCount(int deptDeleteCount) {
		this.deptDeleteCount = deptDeleteCount;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}
	
}
