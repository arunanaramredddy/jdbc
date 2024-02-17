
package com.tap;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.Scanner;

public class CLOB{
	
	static final Scanner scan=new Scanner(System.in);
	private static Connection connection;
	private static PreparedStatement statement;
	private static FileReader fr;
	 
	
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="root";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			statement=connection.prepareStatement("UPDATE `employee` SET `dp`= ? WHERE id=? ");

            statement.setInt(2, scan.nextInt());
			
            fr=new FileReader("C:\\Users\\Dell\\eclipse-workspace\\JDBC\\self");
            statement.setCharacterStream(1,fr);
            int i=statement.executeUpdate();
            System.out.println();
            
			
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}
