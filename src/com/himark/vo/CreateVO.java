package com.himark.vo;

import java.util.List;

public class CreateVO {
	private String tempTable;
	private List<String> columnList;
	
	public CreateVO(String tempTable, List<String> columnList) {
		super();
		this.tempTable = tempTable;
		this.columnList = columnList;
	}
	
	public String getTempTable() {
		return tempTable;
	}
	
	public void setTempTable(String tempTable) {
		this.tempTable = tempTable;
	}
	
	public List<String> getColumnList() {
		return columnList;
	}
	
	public void setColumnList(List<String> columnList) {
		this.columnList = columnList;
	}
	
}
