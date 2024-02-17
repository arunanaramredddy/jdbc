package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		ResultSet res=null;
		
		
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection(url,username,password);
			 statement=connection.createStatement();
			 res = displayemployees(statement);
			 
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
	                                                                               //if we are created any resources we should close the resources using finally block
			e.printStackTrace();
		}
		finally {
			close(connection, statement, res);
					
		}
		
		
	}


	public static ResultSet displayemployees(Statement statement) throws SQLException {
		ResultSet res;
		res=statement.executeQuery("SELECT * FROM employee");
		
		 while (res.next()) {
			 System.out.println(res.getInt("id") + ","+
					 res.getString("name") + ","+
					 res.getString("email") + ","+
					 res.getString("dept") + ","+
					 res.getInt("salary"));
		 }
		return res;
	}


	public static void close(Connection connection, Statement statement, ResultSet res) {
		try {
			if(res!=null ) {
				res.close();

			}
						} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		
		try {
			if(statement!=null) {
				statement.close();
			}
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		try {
			if(connection!=null) {
				connection.close();
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
