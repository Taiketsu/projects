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
			
			String[] creds = System.getenv("DBCreds").split(";");
			
			conn = DriverManager.getConnection(creds[0], creds[1], creds[2]);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	return conn;
	}

}
