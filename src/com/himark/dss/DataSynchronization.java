package com.himark.dss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.himark.data.Dept;
import com.himark.data.Duty;
import com.himark.data.Pos;
import com.himark.data.User;

public class DataSynchronization {
	public static void main(String[] args) {
		
		// 프로퍼티 파일을 읽어서 저장할 리스트
		List<String> properties = new ArrayList<String>();
		
		// 프로퍼티 파일 읽어오기
		try {
			// 파일 객체 생성
			File file = new File("C:/properties/dream.properties"); // 파일은 입력받을 수 있도록 수정할 예정
			
			// 입력 스트림 생성
            FileReader filereader = new FileReader(file);
            
            // 입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            
            String line = "";
            line = bufReader.readLine(); // .readLine()은 끝에 개행문자를 읽지 않음            
            bufReader.close();
            
            properties = Arrays.asList(line.split(","));
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 리스트 확인
		/*
		 * for(String s : properties) { System.out.println(s); }
		 */
		
		// 고객사 DB 연결
		Connection conn = DBConnection.getConnectivity(properties.get(2), properties.get(3), properties.get(4));
		
		// 고객사 데이터를 저장할 리스트 선언
		List<User> userList = new LinkedList<>();
		List<Pos> posList = new LinkedList<>();
		List<Duty> dutyList = new LinkedList<>();
		List<Dept> deptList = new LinkedList<>();
		
		// 고객사 데이터 리스트에 저장
		userList = DataProcess.saveClientUser(conn, properties);
		posList = DataProcess.saveClientPos(conn, properties);
		dutyList = DataProcess.saveClientDuty(conn, properties);
		deptList = DataProcess.saveClientDept(conn, properties);
		
		// 저장한 고객사 데이터 확인
		/*
		 * for(User user : userList) { System.out.println(user); }
		 * 
		 * for(Pos pos : posList) { System.out.println(pos); }
		 * 
		 * for(Duty duty : dutyList) { System.out.println(duty); }
		 * 
		 * for(Dept dept : deptList) { System.out.println(dept); }
		 */
		
		// 고객사 데이터를 마크애니 DB의 temp 테이블에 저장
		int userInsertCount = DataProcess.saveTempUser(userList);
		int posInsertCount = DataProcess.saveTempPos(posList);
		int dutyInsertCount = DataProcess.saveTempDuty(dutyList);
		int deptInsertCount = DataProcess.saveTempDept(deptList);
		
		System.out.println("temp_user에 insert한 개수: " + userInsertCount + "개");
		System.out.println("temp_pos에 insert한 개수: " + posInsertCount + "개");
		System.out.println("temp_duty에 insert한 개수: " + dutyInsertCount + "개");
		System.out.println("temp_dept에 insert한 개수: " + deptInsertCount + "개");
		
		DataProcess.copyDept();
		DataProcess.copyDuty();
		DataProcess.copyPos();
		DataProcess.setApprover();
		DataProcess.copyUser();
		
		
	}

}
