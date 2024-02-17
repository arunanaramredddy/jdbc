
package com.tap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class BLOB{
	
	static final Scanner scan=new Scanner(System.in);
	private static Connection connection;
	private static PreparedStatement statement;
	private static FileInputStream fis;
	
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="root";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url,username,password);
			
			statement=connection.prepareStatement("UPDATE `employee` SET `dp`= ? WHERE id=? ");

            statement.setInt(2, scan.nextInt());
			
            fis=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\JDBC\\Images\\Aruna.jpg");
            statement.setBinaryStream(1,fis);
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
