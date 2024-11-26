package com.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;



public class SelectQuery {
	private static String url="jdbc:mysql://localhost:3306/adv-java";
	private static String user="root";
	private static String pass="root";
	
	public static void main(String [] args) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pass);
			String query="select * from person";
			Statement s=conn.createStatement();
			ResultSet r=s.executeQuery(query);
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getInt(3));
				System.out.println(r.getString(4));
				System.out.println(r.getString(5));
				System.out.println("_____________________");
				
			}
			
			
			
			
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
}
}
