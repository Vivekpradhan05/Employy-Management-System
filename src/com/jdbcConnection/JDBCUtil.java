package com.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String url  = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user_name= "scott";
	private static final String password = "tiger";
	
	//This is connection Code
	
	public static Connection createConnection() {
		Connection conn = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    conn=DriverManager.getConnection(url,user_name,password);
		System.out.println("Connection Successful");
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return conn;
     }
	
}
