package com.kitri.util;

import java.sql.*;

public class DBConnection {
	
	
	private DBConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	
	private static class Holder {
		public static final DBConnection INSTANCE = new DBConnection();
	}
	
	public static DBConnection getInstance() {
		return Holder.INSTANCE;
	}
	
	
	public static Connection makeConnection() throws SQLException {	
	return DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe","kitri","kitri");
	
	}
}
