package com.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDynamically {
	private static String url="jdbc:mysql://localhost:3306/adv-java";
	private static String user="root";
	private static String pass="root";
	
	public static void main(String [] args) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, pass);
			String query="delete from person where id=?";
			PreparedStatement p=conn.prepareStatement(query);
			
			p.setInt(1, 5);
			p.execute();
			
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
