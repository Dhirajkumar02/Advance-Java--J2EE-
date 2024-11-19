package com.jsp.jdbc.employeedb;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDao {
	public static Connection buildConnection(){
		Connection conn = null;
		try {
			// Load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?useSSL=false&autoReconnect=true", "root", "DHIraj@2002");		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;	
	}

	// Insert the employee data
	public void addEmployee() {
		Connection conn = buildConnection();
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);

		try {
			//			---------- User Input -------
			System.out.print("Enter Employee Id: ");
			int employeeId = sc.nextInt();
			sc.nextLine(); // for newline 
			System.out.print("Enter Employee Name: ");
			String employeeName = sc.nextLine();
			System.out.print("Enter Employee Email: ");
			String employeeEmail = sc.nextLine();
			System.out.print("Enter Employee Designation: ");
			String employeeDesc = sc.nextLine();
			System.out.print("Enter Employee Age: ");
			int employeeAge = sc.nextInt();
			System.out.print("Enter Employee Salary: ");
			int employeeSalary = sc.nextInt();

			// Prepare SQL query with placeholder
			String sqlQuery = "INSERT INTO employee (employeeId, employeeName, employeeEmail, employeeDesc, employeeAge, employeeSalary) VALUES (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sqlQuery);

			ps.setInt(1, employeeId);
			ps.setString(2, employeeName);
			ps.setString(3, employeeEmail);
			ps.setString(4, employeeDesc);
			ps.setInt(5, employeeAge);
			ps.setInt(6, employeeSalary);

			// Execute the query
			int insertedRows = ps.executeUpdate();
			if(insertedRows > 0) { 
				System.out.println("Data Inserted Successfully!");
			}
			else {
				System.out.println("Data not inserted!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {}
		try {
			if(conn != null)
				conn.close();
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	// Find the employee details by using id
	public void findEmployeeById() {
		Connection conn = buildConnection();
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		try {
			// Take employeeId as input from the user
			System.out.print("Enter Employee Id: ");
			int employeeId = sc.nextInt();

			// Create the Statement with sql query
			String sqlQuery = "SELECT * FROM employee where employeeId = ?";
			ps = conn.prepareStatement(sqlQuery);

			ps.setInt(1, employeeId);

			// Execute the query
			ResultSet rs = ps.executeQuery();

			// Process the data
			if(rs.next()) {
				System.out.println("Employee ID: " + rs.getInt("employeeId"));
				System.out.println("Employee Name: " + rs.getString("employeeName"));
				System.out.println("Employee Email: " + rs.getString("employeeEmail"));
				System.out.println("Employee Designation: " + rs.getString("employeeDesc"));
				System.out.println("Employee Age: " + rs.getInt("employeeAge"));
				System.out.println("Employee Salary: " + rs.getInt("employeeSalary"));
			}else {
				System.out.println("No employee found: "+employeeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sc.close();
		}

	}
	
	// Update employee data
	public void updateEmployeeById() {
		Connection conn = buildConnection();
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps = null;
		
		try {
            // Take the employee ID to update
            System.out.print("Enter Employee ID to update: ");
            int employeeId = sc.nextInt();
            sc.nextLine();

            // Take new employee data from the user
            System.out.print("Enter new employee name: ");
            String employeeName = sc.nextLine();
            System.out.print("Enter new employee email: ");
            String employeeEmail = sc.nextLine();
            System.out.print("Enter new employee designation: ");
            String employeeDesc = sc.nextLine();
            System.out.print("Enter new employee age: ");
            int employeeAge = sc.nextInt();
            System.out.print("Enter new employee salary: ");
            int employeeSalary = sc.nextInt();
            
            // SQL update query
            String sqlQuery = "UPDATE employee SET employeeName = ?, employeeEmail = ?, employeeDesc = ?, employeeAge = ?, employeeSalary = ? WHERE employeeId = ?";
            ps = conn.prepareStatement(sqlQuery);

            // Set the parameters
            ps.setString(1, employeeName);
            ps.setString(2, employeeEmail);
            ps.setString(3, employeeDesc);
            ps.setInt(4, employeeAge);
            ps.setDouble(5, employeeSalary);
            ps.setInt(6, employeeId);
            
            // Execute the update
            int updateRow = ps.executeUpdate();
            if (updateRow > 0) {
                System.out.println("Employee data updated successfully.");
            } else {
                System.out.println("No employee found: " + employeeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) 
                	ps.close();  // Close the PreparedStatement
                if (conn != null) 
                	conn.close();  // Close the Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sc.close();
        }

	}
	public void deleteEmployeeById() {
		 Connection conn = buildConnection();
	        Scanner sc = new Scanner(System.in);
	        PreparedStatement ps = null;

	        try {
	            // Take the employee ID from the user to delete
	            System.out.print("Enter Employee ID to delete: ");
	            int employeeId = sc.nextInt();
	            
	            // SQL delete query
	            String sqlQuery = "DELETE FROM employee WHERE employeeId = ?";
	            ps = conn.prepareStatement(sqlQuery);

	            // Set the parameter (employeeId)
	            ps.setInt(1, employeeId);

	            // Execute the delete query
	            int deleteRow = ps.executeUpdate();
	            if (deleteRow > 0) {
	                System.out.println("Employee data deleted successfully.");
	            } else {
	                System.out.println("No employee found: " + employeeId);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (ps != null) ps.close();  // Close the PreparedStatement
	                if (conn != null) conn.close();  // Close the Connection
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            sc.close();
	        }
	}
	
	public void updateSalaryBetweenAge(){
		Connection conn = buildConnection();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
        	String sqlQuery = "SELECT employeeId, employeeSalary from  employee WHERE employeeAge BETWEEN  ? AND ?";
            ps = conn.prepareStatement(sqlQuery);
            System.out.print("Enter the minimum age: ");
            ps.setInt(1, sc.nextInt());
            System.out.print("Enter the maximum age: ");
            ps.setInt(2, sc.nextInt());

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int employeeId = rs.getInt("employeeId");
				int currentSalary = rs.getInt("employeeSalary");
				String query = "Update employee SET employeeSalary=? WHERE employeeId=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, currentSalary+100000);
				ps.setInt(2, employeeId);
				ps.executeUpdate();
				
			}
			System.out.println("Salaries Updated successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        sc.close();
		
	}

}
