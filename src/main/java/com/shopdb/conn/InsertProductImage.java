package com.shopdb.conn;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertProductImage {
	public static void main(String args[]){
		Connection conn = null;	
	try {
		//get connection
		conn = JDBCUtil.getConnection();
		File file = new File("/home/aj/Desktop/product_images/maggi.jpg");
		FileInputStream fis = new FileInputStream(file);
		PreparedStatement ps = conn.prepareStatement("UPDATE product SET image= ? WHERE name = ?");
		ps.setBinaryStream(1, fis, file.length());
		ps.setString(2, "Maggie");
		ps.executeUpdate();
		ps.close();
		fis.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
