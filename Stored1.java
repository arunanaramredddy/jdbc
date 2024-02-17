
package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Stored1{
	
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
			
			prepareCall=connection.prepareCall("{call count_emp_salary(?)}");
			prepareCall.setInt(1, scan.nextInt());
			prepareCall.registerOutParameter(1, Types.INTEGER);
			prepareCall.execute();
			int res=prepareCall.getInt(1);
			System.out.println(res);
			
			
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
