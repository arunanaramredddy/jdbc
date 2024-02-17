package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program6 {
	

	private static Connection connection;
	private static Statement statement; 
	private static PreparedStatement pstmt;
	private static ResultSet res;
	
    private static Scanner scan=new Scanner(System.in);
    
	public static void main(String[] args) {
	
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="root";
		
		String sql="INSERT into employee(`id`,`name`,`email`,`dept`,`salary`)values(?,?,?,?,?) ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			Program5.displayemployees(connection);
			
			pstmt=connection.prepareStatement(sql);
			
			System.out.println("ID");
			pstmt.setInt(1,scan.nextInt());
			
			System.out.println("Name");
			pstmt.setString(2, scan.next());

			
			System.out.println("Email");
			pstmt.setString(3, scan.next());
			
			System.out.println("Department");
			pstmt.setString(4, scan.next());
			
			System.out.println("Salary");
			pstmt.setInt(5,scan.nextInt());
			
			
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
         System.out.println("-------------------------------------------------------------");
         while (res.next()) {
             System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-7d |\n", res.getInt("id"), res.getString("name"),
                     res.getString("email"), res.getString("dept"), res.getInt("salary"));
         }
         System.out.println("-------------------------------------------------------------");


		}

}



