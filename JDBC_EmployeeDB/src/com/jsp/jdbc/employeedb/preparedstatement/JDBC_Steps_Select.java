package com.jsp.jdbc.employeedb.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_Steps_Select {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;

		try {
			// Steps-1 Load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Steps -2 Establish the connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbc_employeedb?autoReconnect=true&useSSL=false&user=root&password=DHIraj@2002");

			// Steps-3 Create Statement
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE employeeId=?");
			System.out.print("Enter employee id: ");
			ps.setInt(1, sc.nextInt());

			// Steps-4 Execute the query
//			boolean result = ps.execute();
			ResultSet rs = ps.executeQuery();
			System.out.println("EmployeeId\tEmployeeName\tEmployeeEmail\tEmployeeDesc\tEmployeeAge\tEmployeeSalary");


			// steps-5 
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t\t");
				System.out.print(rs.getString(2)+"\t\t");
				System.out.print(rs.getString(3)+"\t\t");
				System.out.print(rs.getString(4)+"\t\t");
				System.out.print(rs.getInt(5)+"\t\t");
				System.out.print(rs.getInt(6)+"\t\t");
			}
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


/*
   // Define table headers with specified widths
            String format = "%-12s %-20s %-30s %-20s %-10s %-10s%n";
            System.out.printf(format, "EmployeeId", "EmployeeName", "EmployeeEmail", "EmployeeDesc", "EmployeeAge", "EmployeeSalary");

            // Step 5 - Process the ResultSet
            while (rs.next()) {
                System.out.printf(
                    format,
                    rs.getInt("EmployeeId"),
                    rs.getString("EmployeeName"),
                    rs.getString("EmployeeEmail"),
                    rs.getString("EmployeeDesc"),
                    rs.getInt("EmployeeAge"),
                    rs.getDouble("EmployeeSalary")
                );
            }
 */

