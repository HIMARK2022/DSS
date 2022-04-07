package com.himark.dss;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataSynchronization {
	public static void main(String[] args) {
		
		// 로그 파일 생성
		String path = "E:" + File.separator + "DSS_log"; // 폴더 경로
		CreateLog.createFolder(path);
		File file = CreateLog.createFile(path);
		
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			
			writer.write(CreateLog.getRealTime() + "인사연동 시작");
			writer.newLine();
			
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
			
//			writer.write(CreateLog.getRealTime() + "프로퍼티 파일 읽어옴");
//			writer.newLine();
			
			
			// 고객사 데이터를 마크애니 DB의 temp 테이블에 저장
			DataProcess.saveTempPos(pos);
			DataProcess.saveTempDuty(duty);
			DataProcess.saveTempDept(dept);
			DataProcess.saveTempUser(user);
			
			writer.write("-------------------------------------------------------------------");
			writer.newLine();
			
			// 새로운 데이터만 insert
			int posInsertCount = DataProcess.insertPos();
			writer.write(CreateLog.getRealTime() + "pos 테이블에 " + posInsertCount + "건 추가되었습니다.");
			writer.newLine();
			
			int dutyInsertCount = DataProcess.insertDuty();
			writer.write(CreateLog.getRealTime() + "duty 테이블에 " + dutyInsertCount + "건 추가되었습니다.");
			writer.newLine();
			
			int deptInsertCount = DataProcess.insertDept();
			writer.write(CreateLog.getRealTime() + "dept 테이블에 " + deptInsertCount + "건 추가되었습니다.");
			writer.newLine();
			
			int managerInsertCount = DataProcess.insertManager();
			writer.write(CreateLog.getRealTime() + "manager 테이블에 " + managerInsertCount + "건 추가되었습니다.");
			writer.newLine();
			
			int userInsertCount = DataProcess.insertUser();
			writer.write(CreateLog.getRealTime() + "user 테이블에 " + userInsertCount + "건 추가되었습니다.");
			writer.newLine();
			
			writer.write("-------------------------------------------------------------------");
			writer.newLine();
			
			
			// 데이터가 없거나 '퇴직'상태일 시 퇴직 처리
			int posDeleteCount = DataProcess.deletePos();
			writer.write(CreateLog.getRealTime() + "pos 테이블에서 " + posDeleteCount + "건 삭제되었습니다.");
			writer.newLine();
			
			int dutyDeleteCount = DataProcess.deleteDuty();
			writer.write(CreateLog.getRealTime() + "duty 테이블에서 " + dutyDeleteCount + "건 삭제되었습니다.");
			writer.newLine();
			
			int deptDeleteCount = DataProcess.deleteDept();
			writer.write(CreateLog.getRealTime() + "dept 테이블에서 " + deptDeleteCount + "건 삭제되었습니다.");
			writer.newLine();
			
			int managerDeleteCount = DataProcess.deleteManager();
			writer.write(CreateLog.getRealTime() + "manager 테이블에서 " + managerDeleteCount + "건 삭제되었습니다.");
			writer.newLine();
			
			int userDeleteCount = DataProcess.deleteUser();
			writer.write(CreateLog.getRealTime() + "user 테이블에서 " + userDeleteCount + "건 삭제되었습니다.");
			writer.newLine();
			
			writer.write("-------------------------------------------------------------------");
			writer.newLine();
			
			
			// update
			int posUpdateCount = DataProcess.updateDuty();
			writer.write(CreateLog.getRealTime() + "pos 테이블이 " + posUpdateCount + "건 변경되었습니다.");
			writer.newLine();
			
			int dutyUpdateCount = DataProcess.updatePos();
			writer.write(CreateLog.getRealTime() + "duty 테이블이 " + dutyUpdateCount + "건 변경되었습니다.");
			writer.newLine();
			
			int deptUpdateCount = DataProcess.updateDept();
			writer.write(CreateLog.getRealTime() + "dept 테이블이 " + deptUpdateCount + "건 변경되었습니다.");
			writer.newLine();
			
			int userUpdateCount = DataProcess.updateUser();
			writer.write(CreateLog.getRealTime() + "user 테이블이 " + userUpdateCount + "건 변경되었습니다.");
			writer.newLine();
			
			writer.write("--------------------------------------------------------------");
			writer.newLine();
			
			
			writer.write(CreateLog.getRealTime() + "인사연동 종료");
			
			writer.close();
			
		} catch (IOException e) {
			
		}
		
		
		/*
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
		*/
		
	}

}
