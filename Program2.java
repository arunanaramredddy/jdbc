package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	private static Connection connection;
	private static Statement statement; 

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="root";
		
		String sql="UPDATE `employee` "
				+ "SET `salary`=`salary`+5000 "
				+ "where dept='IT'";
				try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			statement=connection.createStatement();
			int i=statement.executeUpdate(sql);
			System.out.print(i);
			
		} catch (ClassNotFoundException e)
				{
			e.printStackTrace();
		} 
				catch (SQLException e) 
		  {
            e.printStackTrace();
		}
		
	}

}
