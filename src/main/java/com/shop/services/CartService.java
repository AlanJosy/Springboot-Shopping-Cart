package com.shop.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.shop.models.CartItem;
import com.shop.models.Product;
import com.shopdb.conn.JDBCUtil;

@Service
public class CartService {
	Connection conn = null;
	Integer iprice=null;
	String iname=null;
	public void addtocart(Integer pid,Integer quantity){	
		
		String SQLfind="SELECT * FROM product WHERE pid=?";
		try(			
			//get connection
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SQLfind)) {

	            preparedStatement.setInt(1, pid);

	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	            	System.out.println(rs.getString("name")+rs.getInt("price"));
	            	iprice=rs.getInt("price");
	            	iname=rs.getString("name");
	            }
	            
	            
	            
	            

	        } catch (SQLException e) {
	            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		String SQLinsert="INSERT INTO cartitem(custid, pid, name, quantity, unitprice, iamount)VALUES (?, ?, ?, ?, ?, ?)ON CONFLICT(custid,pid) DO UPDATE SET quantity=?,iamount=?";

		try(			
				//get connection
				Connection conn = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(SQLinsert)) {

		            preparedStatement.setInt(1, 1);
		            preparedStatement.setInt(2, pid);
		            preparedStatement.setString(3, iname);
		            preparedStatement.setInt(4, quantity);
		            preparedStatement.setInt(5, iprice);
		            
		            Integer iamount=quantity*iprice;
		            
		            preparedStatement.setInt(6, iamount);
//		            for updates
		            preparedStatement.setInt(7, quantity);
		            preparedStatement.setInt(8, iamount);


		            


		            Integer r = preparedStatement.executeUpdate();
		            if (r!=null) {
		            	System.out.println("added to cart");
		            }
		            
		            
		            

		        } catch (SQLException e) {
		            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		
	}
	
	public List<CartItem> getCart(Integer cust_id){
		ArrayList<CartItem> cartlist = new ArrayList<CartItem>();
//		listOfProducts.add(new Product(001,"IPHONEX",1200.83));
//		listOfProducts.add(new Product(002,"IPHONX",1203.00));
		String SQLsearch="SELECT * FROM cartitem WHERE custid=?";
		try(			
			//get connection
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SQLsearch)){
 

			 preparedStatement.setInt(1, cust_id);
			 ResultSet rs = preparedStatement.executeQuery();
	         
	         while (rs.next()) {
	            int id = rs.getInt("pid");
	            String name = rs.getString("name");
	            Double price = (double) rs.getInt("unitprice");
	            int quantity = rs.getInt("quantity");
	            System.out.println("taking records");

	            cartlist.add(new CartItem(id,name,price,quantity));
	            
//	            System.out.println(id+"   "+name+"    "+price);
	         }
			//close connection
			conn.close();
 
			System.out.println("Table records retrieved");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return cartlist;
	}
	
	public void delitem(Integer cust_id,Integer pid){
		
		String SQLsearch="DELETE FROM cartitem WHERE custid=? AND pid=?";
		try(			
			//get connection
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(SQLsearch)){
 

			 preparedStatement.setInt(1, cust_id);
			 preparedStatement.setInt(2, pid);
			 int n = preparedStatement.executeUpdate();
			 
			 if(n>0){
				 System.out.println("record deleted");
			 }
			 
			 
	         
	        
			//close connection
			conn.close();
 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
//	public Product getProductById(Integer id) {
//
//		Predicate<Product> byId = p -> p.getId().equals(id);
//		return filterProducts(byId);
//	}
//
//	public Product filterProducts(Predicate<Product> strategy) {
//		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
//}
}
