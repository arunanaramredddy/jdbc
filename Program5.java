package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program5 {
	

	private static Connection connection;
	private static Statement statement; 
	private static PreparedStatement pstmt;
	
    private static Scanner scan=new Scanner(System.in);
    
	public static void main(String[] args) {
	
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="root";
		
		String sql="UPDATE `employee` SET `salary`=`salary`+ ? where `dept`= ? ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			 
			Program5.displayemployees(connection);
			
			
			pstmt=connection.prepareStatement(sql);
			
			System.out.println("Enter the department");
			String department=scan.next();
			
			System.out.println("Enter the hike");
			int inc=scan.nextInt();
			
			pstmt.setInt(1,inc);
			pstmt.setString(2,department);
			
			int i=pstmt.executeUpdate();
			System.out.println(i);
			 
			Program5.displayemployees(connection);
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
		public static void displayemployees(Connection connection) throws SQLException {
	     statement= connection.createStatement();
		 ResultSet res=statement.executeQuery("SELECT * FROM employee");
			
			 while (res.next()) {
				 System.out.println(res.getInt("id") + ","+
						 res.getString("name") + ","+
						 res.getString("email") + ","+
						 res.getString("dept") + ","+
						 res.getInt("salary"));
			 }
			 System.out.println("--------------------------------------------");
		}
		

		}
			

			