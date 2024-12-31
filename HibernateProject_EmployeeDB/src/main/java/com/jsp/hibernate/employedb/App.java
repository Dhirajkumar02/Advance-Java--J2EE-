package com.jsp.hibernate.employedb;

import java.util.Scanner;

import com.jsp.hibernate.employeedb.dao.EmployeeDao;

public class App 
{
    public static void main( String[] args )
    {
//        EmployeeDao employeeDao = new EmployeeDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose an operation:");
        System.out.println("1. Add Employee");
        System.out.println("2. Find Employee by ID");
        System.out.println("3. Update Employee by ID");
        System.out.println("4. Delete Employee by ID");
        System.out.println("5. Exit");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                EmployeeDao.addEmployee();
                break;

            case 2:
                EmployeeDao.findEmployeeById();
                break;

            case 3:
               EmployeeDao.updateEmployeeDescAndSalaryById();
                break;

            case 4:
                EmployeeDao.deleteEmployeeById();
                break;
                
            case 5:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }

        sc.close();
    }
}
