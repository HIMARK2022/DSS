package com.himark.dss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.himark.data.Dept;
import com.himark.data.Duty;
import com.himark.data.Pos;
import com.himark.data.User;

public class DataSynchronization {
	public static void main(String[] args) {

		// dept 테이블로 MyBatis 테스트
//		DeptService deptService = new DeptService();
//		List<Dept> deptList = deptService.select();
//		
//		for(Dept dept : deptList) {
//			System.out.println(dept.getDeptId() + " " + dept.getDeptName() + " " + dept.getUpperDeptId());
//		}
		
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
		for(String s : properties) {
			System.out.println(s);
		}
				
	}

}
