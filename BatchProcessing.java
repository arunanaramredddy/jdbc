package com.tap;

		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
		import java.util.Scanner;


public class BatchProcessing { 
			

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
					
					
					pstmt=connection.prepareStatement(sql);
					
					String choice=null;
					do {
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
						
						
						pstmt.addBatch();
									
						
						System.out.println("Do you want to enter more employees(yes/no)");
						choice =scan.next();
						
					} while(choice.equalsIgnoreCase("yes"));
					int[] ar=pstmt.executeBatch();
					for(int i:ar) {
						System.out.println(i);
					}
						
					
								
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
						 System.out.printf("%-2d  %-8s  %-20s  %-8s  %-7d\n",res.getInt("id"),res.getString("name"), res.getString("email"), res.getString("dept"),res.getInt("salary"));
					 }
					 System.out.println("--------------------------------------------");
				}
		


			

	}


