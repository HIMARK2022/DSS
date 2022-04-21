package com.himark.vo;

import java.util.List;

public class JoinVO {
	private String defaultTable;
	private String defaultColumn;
	private List<String> joinTables;
	
	public JoinVO(String defaultTable, String defaultColumn, List<String> joinTables) {
		super();
		this.defaultTable = defaultTable;
		this.defaultColumn = defaultColumn;
		this.joinTables = joinTables;
	}

	public String getDefaultTable() {
		return defaultTable;
	}

	public void setDefaultTable(String defaultTable) {
		this.defaultTable = defaultTable;
	}

	public String getDefaultColumn() {
		return defaultColumn;
	}

	public void setDefaultColumn(String defaultColumn) {
		this.defaultColumn = defaultColumn;
	}

	public List<String> getJoinTables() {
		return joinTables;
	}

	public void setJoinTables(List<String> joinTables) {
		this.joinTables = joinTables;
	}
	
}
