package com.shopdb.conn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Productdbtest {
	public static void main(String args[]){
		Connection conn = null;
		
		try{			
			//get connection
			conn = JDBCUtil.getConnection();
	
	//		//create statement
	//		statement = conn.createStatement();
	//
	//		//execute query
	//		statement.execute(query);
			
			Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM product ");
	         System.out.println("id  name    price");
	         
	         while (rs.next()) {
	            int id = rs.getInt("pid");
	            String name = rs.getString("name");
	            Double price = (double) rs.getInt("price");
	            
	//            listOfProducts.add(new Product(id,name,price));
	            
	            System.out.println(id+"   "+name+"    "+price);
	         }
			//close connection
			stmt.close();
			conn.close();
	
			System.out.println("Table created successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
