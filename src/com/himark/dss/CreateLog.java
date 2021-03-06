package com.himark.dss;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateLog {
	
	public static String getRealTime() {
		long systemTime = System.currentTimeMillis();
		
		SimpleDateFormat logSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		
		String realTime = "["+ logSdf.format(systemTime) + "] ";
		
		//System.out.println(realTime);
		
		return realTime;
		
	}
	
	public static void createFolder(String path) {
		
		File Folder = new File(path);

		// 해당 디렉토리가 없을경우 디렉토리를 생성
		if (!Folder.exists()) {
			
			try {
				Folder.mkdir(); // 폴더 생성
				System.out.println("폴더가 생성되었습니다.");
			} catch (Exception e) {
				e.getStackTrace();
			}
			
		} else {
			System.out.println("이미 폴더가 있습니다.");
		}
	}
	
	public static File createFile(String path) {
		
		// 오늘 날짜 포맷에 맞게 설정
		SimpleDateFormat folderSdf = new SimpleDateFormat("yyMMdd", Locale.KOREA);
		Calendar calendar = Calendar.getInstance(); 
		String today = folderSdf.format(calendar.getTime());

		// 파일 이름
		String fileName = File.separator + "dss_";
		fileName += today;
		fileName += ".log";
		//System.out.println(path + fileName);
		
		// 파일 생성
		File file = new File(path + fileName);
		
		try {
			
			if (file.createNewFile()) {
				System.out.println("파일이 생성되었습니다.");
			} else {
				System.out.println("이미 파일이 있습니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}
	
}
