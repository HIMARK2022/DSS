package com.himark.excel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.himark.service.ExcelService;

public class ExcelProcess {
	
	public static void csvProcess(String path, String fileName) {
		List<String> firstLine = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		ExcelService excelService = new ExcelService();
		BufferedReader br = null;
		String var = "";
		String line = "";
		
		try {
			br = Files.newBufferedReader(Paths.get(path + "/" + fileName + ".csv"));
			Charset.forName("UTF-8");
			firstLine = Arrays.asList(br.readLine().split(",")); // 첫행

			for (int i = 0; i < firstLine.size(); i++) {
				if (i == firstLine.size() - 1) {
					var += "`" + firstLine.get(i) + "`" + " VARCHAR(100)";
				} 
				else {
					var += "`" + firstLine.get(i) + "`" + " VARCHAR(100),";
				}
			}
			
			String createTable = "CREATE TABLE " + fileName + " (" + var + ")";
			String dropTable = "DROP TABLE IF EXISTS `" + fileName + "`";
			
			//DROP TABLE IF EXISTS
			excelService.dropTable(dropTable);
			System.out.println("기존 '"+ fileName +"' 테이블 삭제");
			//CREATE TABLE
			excelService.createTable(createTable);
			System.out.println("'"+fileName+"' 테이블 생성");
			
			//INSERT
			List<String> tmpList = new ArrayList<String>();
			for (int i = 0; i < firstLine.size(); i++) {
				while ((line = br.readLine()) != null) {
					String array[] = line.split(",", -1);
					tmpList = Arrays.asList(array);
					String insertTable = "INSERT INTO `" + fileName + "` VALUES (";
					for (int j = 0; j < firstLine.size(); j++) {
						if (j == firstLine.size() - 1) {
							if (tmpList.get(j).equals("")) {
								insertTable += null;
							} 
							else {
								insertTable += "'" + tmpList.get(j) + "'";
							}
						} 
						else {
							if (tmpList.get(j).equals("")) {
								insertTable += null+",";
							} else {
								insertTable += "'" + tmpList.get(j) + "',";
							}
						}
					}
					insertTable += ")";
					excelService.insertTable(insertTable);
					System.out.println(insertTable);
				}
			}
			
			System.out.println("데이터 삽입 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
