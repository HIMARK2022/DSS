package com.himark.dss;

public class DataSynchronization {
	public static void main(String[] args) {
		
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
		DataProcess.saveTempUser(user);
		DataProcess.saveTempPos(pos);
		DataProcess.saveTempDuty(duty);
		DataProcess.saveTempDept(dept);
		
		//System.out.println("temp_user에 insert한 개수: " + userInsertCount + "개");
		//System.out.println("temp_pos에 insert한 개수: " + posInsertCount + "개");
		//System.out.println("temp_duty에 insert한 개수: " + dutyInsertCount + "개");
		//System.out.println("temp_dept에 insert한 개수: " + deptInsertCount + "개");
		
		//DataProcess.copyDept();
		//DataProcess.copyDuty();
		//DataProcess.copyPos();
		//DataProcess.setApprover();
		//DataProcess.copyUser();
		
	}

}
