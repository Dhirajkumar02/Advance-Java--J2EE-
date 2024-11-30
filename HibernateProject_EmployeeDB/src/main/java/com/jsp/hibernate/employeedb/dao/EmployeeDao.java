package com.jsp.hibernate.employeedb.dao;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.jsp.hibernate.employeedb.entity.Employee;

public class EmployeeDao {

    public static Session getSession() {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        return sf.openSession();
    }

    public static void addEmployee() {
        Employee emp = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Id: ");
        emp.setId(sc.nextInt());
        sc.nextLine(); // Consume leftover newline
        System.out.print("Enter Employee Name: ");
        emp.setName(sc.nextLine());
        System.out.print("Enter Employee Email: ");
        emp.setEmail(sc.nextLine());
        System.out.print("Enter Employee Age: ");
        emp.setAge(sc.nextInt());
        sc.nextLine(); // Consume leftover newline
        System.out.print("Enter Employee Designation: ");
        emp.setDesc(sc.nextLine());
        System.out.print("Enter Employee Salary: ");
        emp.setSal(sc.nextDouble());

        Session session = getSession();
        Transaction tran = session.beginTransaction();
        session.save(emp);
        tran.commit();
        session.close();
        sc.close();
    }

    public static void findEmployeeById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Id: ");
        int id = sc.nextInt();

        Session session = getSession();
        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            System.out.print(emp);
        } else {
            System.out.print("Employee not found!");
        }
        session.close();
        sc.close();
    }

    public static void updateEmployeeDescAndSalaryById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Id: ");
        int id = sc.nextInt();
        sc.nextLine(); // for newline
        System.out.print("Enter New Designation: ");
        String desc = sc.nextLine();
        System.out.print("Enter New Salary: ");
        double sal = sc.nextDouble();

        Session session = getSession();
        Transaction tran = session.beginTransaction();
        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            emp.setDesc(desc);
            emp.setSal(sal);
            session.update(emp);
            tran.commit();
        } else {
            System.out.println("Employee not found!");
        }
        session.close();
        sc.close();
    }

    public static void deleteEmployeeById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id to delete: ");
        int id = sc.nextInt();

        Session session = getSession();
        Transaction tran = session.beginTransaction();
        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
            tran.commit();
        } else {
            System.out.println("Employee not found!");
        }
        session.close();
        sc.close();
    }
   
}
