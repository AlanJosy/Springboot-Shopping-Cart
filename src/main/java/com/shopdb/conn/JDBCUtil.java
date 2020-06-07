package com.shopdb.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	//JDBC and database properties.
	private static final String DB_DRIVER ="org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/Shop";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "aj123*";
	 
		public static Connection getConnection(){
			Connection conn = null;
			try{
				//Register the JDBC driver
				Class.forName(DB_DRIVER);
	 
				//Open the connection
				conn = DriverManager.
				getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	 
				if(conn != null){
				   System.out.println("Successfully connected.");
				}else{
				   System.out.println("Failed to connect.");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return conn;
		}	
}