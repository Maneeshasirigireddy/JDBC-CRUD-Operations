package com.Demo;

import java.sql.Connection;
import java.lang.ClassNotFoundException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOperation {
	public static void main(String [] args) {
		Connection c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv-java?user=root&password=root");
			Statement s=c.createStatement();
			String query="insert into person values (5,'lakshmi',30,'lakshmi1@gmail.com','lakshimi@3')";
//			String delQuery="delete from person where id=2";
//			String UpdateQuery="update person set Name='Akhi' where id=2";
//			int noOfRowsUpdated=s.executeUpdate(UpdateQuery);
//			System.out.println(noOfRowsUpdated);
			String q="sel"
					+ "ect id from person";
			boolean isSelect=s.execute(query);
			System.out.println(isSelect);
			if(isSelect) {
				ResultSet set=s.getResultSet();
				System.out.println(set);
			}
			else {
				int count=s.getUpdateCount();
				System.out.println(count);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
