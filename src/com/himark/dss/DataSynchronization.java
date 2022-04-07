package com.himark.dss;

import java.io.File;

public class DataSynchronization {
	public static void main(String[] args) {
		
		String path = "E:" + File.separator + "DSS"; // 폴더 경로
		CreateLog.createFolder(path);
		CreateLog.createFile(path);
		
		// 프로퍼티 파일 읽기
		String[] user = new String[6];
		String[] pos = new String[2];
		String[] duty = new String[2];
		String[] dept = new String[3];
		
		user[0] = DataProcess.getProperty("user.user_id");
		user[1] = DataProcess.getProperty("user.user_name");
		user[2] = DataProcess.getProperty("user.pos_id");
		user[3] = DataProcess.getProperty("user.duty_id");
		user[4] = DataProcess.getProperty("user.dept_id");
		user[5] = DataProcess.getProperty("user.authority_code");
		
		pos[0] = DataProcess.getProperty("pos.pos_id");
		pos[1] = DataProcess.getProperty("pos.pos_name");
		
		duty[0] = DataProcess.getProperty("duty.duty_id");
		duty[1] = DataProcess.getProperty("duty.duty_name");
		
		dept[0] = DataProcess.getProperty("dept.dept_id");
		dept[1] = DataProcess.getProperty("dept.dept_name");
		dept[2] = DataProcess.getProperty("dept.upper_dept_id");
		
		// 고객사 데이터를 마크애니 DB의 temp 테이블에 저장
		DataProcess.saveTempPos(pos);
		DataProcess.saveTempDuty(duty);
		DataProcess.saveTempDept(dept);
		DataProcess.saveTempUser(user);
		
		// 새로운 데이터만 insert
		int posInsertCount = DataProcess.insertPos();
		int dutyInsertCount = DataProcess.insertDuty();
		int deptInsertCount = DataProcess.insertDept();
		int managerInsertCount = DataProcess.insertManager();
		int userInsertCount = DataProcess.insertUser();
		
		//데이터가 없거나 '퇴직'상태일시 퇴직처리
		int posDeleteCount = DataProcess.deletePos();
		int dutyDeleteCount = DataProcess.deleteDuty();
		int deptDeleteCount = DataProcess.deleteDept();
		int managerDeleteCount = DataProcess.deleteManager();
		int userDeleteCount = DataProcess.deleteUser();
		
		System.out.println("================================");
		System.out.println("user에 insert한 개수: " + userInsertCount + "개");
		System.out.println("pos에 insert한 개수: " + posInsertCount + "개");
		System.out.println("duty에 insert한 개수: " + dutyInsertCount + "개");
		System.out.println("dept에 insert한 개수: " + deptInsertCount + "개");
		System.out.println("manager에 insert한 횟수: " + managerInsertCount + "번");
		System.out.println("================================");
		System.out.println("pos에서 delete한 개수: " + posDeleteCount + "개");
		System.out.println("duty에서 delete한 개수: " + dutyDeleteCount + "개");
		System.out.println("dept에서 delete한 개수: " + deptDeleteCount + "개");
		System.out.println("manager에서 delete한 개수: " + managerDeleteCount + "개");
		System.out.println("user에서 delete했었던 개수: " + userDeleteCount + "개");
		System.out.println("================================");
		System.out.println("user에 update한 개수: " + DataProcess.updateUser() + "개");
		System.out.println("pos에 update한 개수: " + DataProcess.updatePos() + "개");
		System.out.println("duty에 update한 개수: " + DataProcess.updateDuty() + "개");
		System.out.println("dept에 update한 개수: " + DataProcess.updateDept() + "개");
		
	}

}
