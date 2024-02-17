package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program4 {
	

	private static Connection connection;
	private static Statement statement; 
	private static PreparedStatement pstmt;
	
    private static Scanner scan=new Scanner(System.in);
    
	public static void main(String[] args) {
	
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="root";
		
		String sql="SELECT * from `employee` where `dept`= ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			pstmt=connection.prepareStatement(sql);
			
			System.out.println("Enter the department");
			
			pstmt.setString(1,scan.next());
			
			ResultSet res=pstmt.executeQuery();
			
			while (res.next()) {
				System.out.println(res.getInt("id") + ","+
				res.getString("name") + ","+
				res.getString("email") + ","+
				res.getString("dept") + ","+
				res.getInt("salary"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
			}

			