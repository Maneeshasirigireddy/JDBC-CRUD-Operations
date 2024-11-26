package com.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDynamic {
	public static void main(String [] args) {
	Connection c=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv-java?user=root&password=root");
		String q="insert into person values(?,?,?,?,?)";
		PreparedStatement p=c.prepareStatement(q);
		p.setInt(1,101);
		p.setString(2, "Maneesha Reddy");
		p.setInt(3, 22);
		p.setString(4, "eesha@gmail.com");
		p.setString(5, "eesha@333");
		p.execute();
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
	try {
		c.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	}

}
