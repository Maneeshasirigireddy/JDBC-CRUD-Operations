package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.employee.EmployeeCrud;

public class Employee {
	private static String url="jdbc:mysql://localhost:3306/employeemanagement";
	private static String user="root";
	private static String pass="root";
	public static Connection c;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection(url,user,pass);
			System.out.println("Welcome to Employee Management");
			boolean f=true;
			while(f) {
			System.out.println("Menu");
			System.out.println("Press 1-> Inserting");
			System.out.println("Press 2-> Updating");
			System.out.println("Press 3-> Deleting");
			System.out.println("Press 4-> Fetching");
			System.out.println("Press 5-> Exit from Menu");
			System.out.println("Press 6-> Exit from Application");
			int i=s.nextInt();
			switch(i) {
			case 1:
				boolean flag=EmployeeCrud.insert();
				if(flag) {
					System.out.println("Data Inserted Successfully");
					
				}
				else {
					System.out.println("Data not Inserted Successfully");
				}
				break;
			case 2:
				boolean flag2=EmployeeCrud.update();
				if(flag2) {
					System.out.println("Data has been Updated");
				}
				else {
					System.out.println("Data not been Updated");
				}
				
				break;
			case 3:
				boolean flag1=EmployeeCrud.delete();
				if(flag1) {
					System.out.println("Data Was Removed");
				}
				else {
					System.out.println("Employee is Not Present");
				}
				
				break;
			case 4:
				EmployeeCrud.fetch();
				
				
				break;
			case 5:
					f=false;
				break;
			
				
			}
			
			
			
			}
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			 
		
		
		}
}

