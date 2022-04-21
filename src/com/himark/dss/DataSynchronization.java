package com.himark.dss;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.himark.service.ClientService;
import com.himark.service.MarkanyService;
import com.himark.vo.InfoVO;

public class DataSynchronization {

	public static void main(String[] args) {
		
		// 로그 파일 생성
		String path = "C:" + File.separator + "DSS" + File.separator + "DSS_LOG"; // 폴더 경로
		CreateLog.createFolder(path);
		File file = CreateLog.createFile(path);
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			
			SimpleDateFormat logSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
			
			long start = System.currentTimeMillis();
			String st = logSdf.format(start);
			String startTime = "["+ st + "] ";
			
			writer.write(startTime + "인사연동 시작");
			writer.newLine();
			
			// DB인지 CSV인지 판별
			String type = DataProcess.getProperty("type");
			
			MarkanyService markanyService = new MarkanyService();
			ClientService clientService = null;
			
			String[] tempTables = null;
			
			if("DB".equals(type)) {
				clientService = new ClientService();
				
				// temp1 생성 (그대로 복사)
				tempTables = DataProcess.getProperties("tablename");
				DataProcess.copyDB(tempTables, markanyService, clientService);
				
			} else {
				
				// temp1 생성 (그대로 복사)
				String filePath = DataProcess.getProperty("filepath");
				tempTables = DataProcess.getProperties("filename");
				DataProcess.copyCSV(tempTables, filePath, markanyService);
				
			}
			
			// temp2 (마크애니와 구조 일치시키기)
			DataProcess.saveTempPos();
			DataProcess.saveTempDuty();
			DataProcess.saveTempDept();
			DataProcess.saveTempUser();
			
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
			
			writer.write("-------------------------------------------------------------------");
			writer.newLine();
			
			long finish = System.currentTimeMillis();
			String ft = logSdf.format(finish);
			String finishTime = "["+ ft + "] ";
			
			writer.write(finishTime + "인사연동 종료 - 걸린 시간: " + (finish-start)/1000.0 + "초");
			
			writer.close();
			
			DataProcess.insertInfo(new InfoVO(userInsertCount, userUpdateCount, userDeleteCount, 
								              deptInsertCount, deptUpdateCount, deptDeleteCount,
								              st, ft));
			
		} catch (IOException e) {
			
		}
	}
	
}
