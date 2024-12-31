package com.jsp.jdbc.employeedb;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an operation:");
        System.out.println("1. Add Employee");
        System.out.println("2. Find Employee by ID");
        System.out.println("3. Update Employee by ID");
        System.out.println("4. Delete Employee by ID");
        System.out.println("5. Update Salary Between Age");
        System.out.println("6. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                employeeDao.addEmployee();
                break;

            case 2:
                employeeDao.findEmployeeById();
                break;

            case 3:
                employeeDao.updateEmployeeById();
                break;

            case 4:
                employeeDao.deleteEmployeeById();
                break;

            case 5:
                employeeDao.updateSalaryBetweenAge();
                break;
            case 6:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }

        scanner.close();
    }
}
