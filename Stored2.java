
package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Stored2{
	
	static final Scanner scan=new Scanner(System.in);
	private static Connection connection;
	private static CallableStatement prepareCall;

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="root";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			prepareCall=connection.prepareCall("{call display_emp(?)}");
			prepareCall.setInt(1, scan.nextInt());
			prepareCall.execute();
			
			ResultSet res=prepareCall.getResultSet();
			
			System.out.println("-------------------------------------------------------------");
	        while (res.next()) {
	            System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-7d |\n", res.getInt("id"), res.getString("name"),
	                    res.getString("email"), res.getString("dept"), res.getInt("salary"));
	        }
	        System.out.println("-------------------------------------------------------------");

 
			
			
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}
