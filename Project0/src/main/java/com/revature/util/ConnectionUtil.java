package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// This uses reflection to confirm that a class with this
		// fully qualified name is available
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@dbtraining.cgprctiahy3l.us-east-2.rds.amazonaws.com:1521:ORCL",
					"john", "securepassword");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	return conn;
	}

}
