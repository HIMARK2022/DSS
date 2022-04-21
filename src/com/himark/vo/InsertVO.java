package com.himark.vo;

import java.util.List;
import java.util.Map;

public class InsertVO {
	private String tempTable;
	private Map<String, Object> keyMap;
	private List<Map<String, Object>> dataMapList;
	
	public InsertVO(String tempTable, Map<String, Object> keyMap, List<Map<String, Object>> dataMapList) {
		super();
		this.tempTable = tempTable;
		this.keyMap = keyMap;
		this.dataMapList = dataMapList;
	}

	public String getTempTable() {
		return tempTable;
	}

	public void setTempTable(String tempTable) {
		this.tempTable = tempTable;
	}

	public Map<String, Object> getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(Map<String, Object> keyMap) {
		this.keyMap = keyMap;
	}

	public List<Map<String, Object>> getDataMapList() {
		return dataMapList;
	}

	public void setDataListMap(List<Map<String, Object>> dataMapList) {
		this.dataMapList = dataMapList;
	}
	
}
