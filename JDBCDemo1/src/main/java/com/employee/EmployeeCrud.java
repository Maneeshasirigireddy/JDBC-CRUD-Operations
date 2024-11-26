package com.employee;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.project.Employee;
public class EmployeeCrud {
	static Scanner s=new Scanner(System.in);
	
	public static boolean insert() {
		boolean f=false;
		System.out.println("Welcome to Insert Data");
		System.out.println("Enter the id of Employee");
		int id=s.nextInt();
		System.out.println("Enter the Name of Employee");
		String n=s.next();
		System.out.println("Enter the age of Employee");
		int a=s.nextInt();
		System.out.println("Enter the  Salary of Employee");
		double sal=s.nextDouble();
		String sql="insert into employee values(?,?,?,?)";
		
		try {
			PreparedStatement p=Employee.c.prepareStatement(sql);
			p.setInt(1, id);
			p.setString(2, n);
			p.setInt(3, a);
			p.setDouble(4, sal);
			p.execute();
			f=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return f;
		
		
	}
	public static boolean update() {
		boolean flag=false;
		System.out.println("Welcome to Updating Data");
		System.out.println("Enter the id of employee you want to update");
		int id=s.nextInt();
		System.out.println("which you want to update \n 1.Id\n2.Name\n3.Age\n4.Salary");
		int choice=s.nextInt();
		
		try {
			
			switch(choice) {
			case 1:
				System.out.println("Enter the id what to Update:");
				String sql="update employee set id=? where id=?";
				PreparedStatement p=Employee.c.prepareStatement(sql);
				int i=s.nextInt();
				
				p.setInt(1, i);
				p.setInt(2, id);
				p.execute();
				flag=true;
				break;
			case 2:
				System.out.println("Enter the Name you want to update");
				String sql2="update employee set Name=? where id=?";
				PreparedStatement p2=Employee.c.prepareStatement(sql2);
				String n=s.next();
				
				p2.setString(1, n);
				p2.setInt(2, id);
				p2.execute();
				flag=true;
				break;
			case 3:
				System.out.println("Enter the Age you want to update");
				String sql3="update employee set Age=? where id=?";
				PreparedStatement p3=Employee.c.prepareStatement(sql3);
				int a=s.nextInt();
				
				p3.setInt(2, a);
				p3.setInt(3, id);
				p3.execute();
				flag=true;
				break;
			case 4:
				System.out.println("Enter the Salary you want to update");
				String sql4="update employee set Salary=? where id=?";
				PreparedStatement p4=Employee.c.prepareStatement(sql4);
				double d=s.nextDouble();
				
				p4.setDouble(2, d);
				p4.setInt(3, id);
				p4.execute();
				flag=true;
				break;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
			
		
		
		
	}
	public static void fetch() {
		
		try {
		String query="select * from employee";
		PreparedStatement p=Employee.c.prepareStatement(query);
		ResultSet r;
		
			r = p.executeQuery();
		
		while(r.next()) {
			System.out.println(r.getInt(1));
			System.out.println(r.getString(2));
			System.out.println(r.getInt(3));
			System.out.println(r.getDouble(4));
			
			System.out.println("_____________________");
			
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static boolean delete() {
		boolean flag=false;
		System.out.println("Now Your Deleting the Employee data");
		System.out.println("Enter the id of employee \n which Employee Details You want Delete");
		int id=s.nextInt();
		try {
			
			
			String query="delete from employee where id=?";
			PreparedStatement p=Employee.c.prepareStatement(query);
			
			p.setInt(1, id);
			p.execute();
			flag=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
