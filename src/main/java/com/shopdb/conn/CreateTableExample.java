package com.shopdb.conn;
import java.sql.Connection;
import java.sql.Statement;


public class CreateTableExample {
	public static void main(String args[]){
		Connection conn = null;
		Statement statement = null;
 
//		String query = "CREATE TABLE public.cartitem\n" + 
//				"(\n" + 
//				"  custid integer NOT NULL,\n" + 
//				"  pid integer NOT NULL,\n" + 
//				"  name character varying(100),\n" + 
//				"  quantity integer,\n" + 
//				"  unitprice integer,\n" + 
//				"  iamount integer,\n" + 
//				"  CONSTRAINT cart_id PRIMARY KEY (custid, pid)\n" + 
//				")\n" + 
//				"WITH (\n" + 
//				"  OIDS=FALSE\n" + 
//				");\n" + 
//				"ALTER TABLE public.cartitem\n" + 
//				"  OWNER TO postgres;";
		String query="CREATE TABLE public.product(pid integer NOT NULL,name character varying(100),price integer,stock integer,CONSTRAINT prod_id PRIMARY KEY (pid))WITH (OIDS=FALSE);ALTER TABLE public.product OWNER TO postgres;";
 
		try{			
			//get connection
			conn = JDBCUtil.getConnection();
 
			//create statement
			statement = conn.createStatement();
 
			//execute query
			statement.execute(query);
 
			//close connection
			statement.close();
			conn.close();
 
			System.out.println("Table created successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	

}
