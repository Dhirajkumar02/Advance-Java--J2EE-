package com.jsp.jdbc.employeedb.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Steps_Delete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		
		try {
			// Steps-1 Load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Steps -2 Establish the connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?user=root&password=DHIraj@2002");
			
			// Steps-3 Create Statement
			PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE employeeId=?");
			System.out.println("Enter employee id: ");
			ps.setInt(1, sc.nextInt());
			
			// Steps-4 Execute the query
			boolean result = ps.execute();
			
			// steps-5 
			if(result == false)
				System.out.println("Data deleted Sucessfully!");
			else
				System.out.println("Data not deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			sc.close();
				
		}
	}

}
