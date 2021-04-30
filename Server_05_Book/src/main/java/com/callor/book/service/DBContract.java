package com.callor.book.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 싱글톤(Single Tone) 패턴
 * 프로젝트를 수행하는데 필요한 자원(Resource)을 만드는 방법으로
 * 같은 자원을 계속해서 만들지 않고 한번만 만들어 두고 여러곳에서 활용하는 방법
 */
public class DBContract {
	
	private static Connection dbConn;
	
	// 메서드 이름이 없는 메서드
	/*
	 * static 자동 생성자 ( 쌤이 임의로 붙이신 이름 )
	 * 
	 * 프로젝트가 Run 되면 무조건 코드가 실행되는 method
	 */
	static {
		String jdbcDriver = "oracle.jdbc.OracleDriver.class"; // < 뒤에 .class 붙이면 오류 > dbConn이 안 만들어지기 때문에 뒤에서 오류가 나는 것
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // < @ 빼면 오류 >
		String username = "bookuser";
		String password = "bookuser";
		
		try {
			Class.forName(jdbcDriver);
			dbConn = DriverManager.getConnection(url,username,password);
			System.out.println("DB Connection OK!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("오라클 DB Driver 없음");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("오라클 DB 연결 오류!!");
		}
	} // end static
	public static Connection getDBConnection() {
		return dbConn;
	}
}
