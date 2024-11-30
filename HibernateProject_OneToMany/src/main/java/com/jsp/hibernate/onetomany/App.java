package com.jsp.hibernate.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Company company = new Company();
    	company.setCompanyId(1);
    	company.setCompanyName("TCS");
    	
    	Employee e1 = new Employee();
    	e1.setEmployeeId(101);
    	e1.setEmployeeName("Saurabh");
    	e1.setEmployeeSalary(35000);
    	
    	Employee e2 = new Employee();
    	e2.setEmployeeId(102);
    	e2.setEmployeeName("Dhiraj");
    	e2.setEmployeeSalary(25000);
    	
//    	// Adding Employee Objects into Company obj
//    	
//    	List<Employee> eList = new ArrayList<Employee>();
//    	eList.add(e1);
//    	eList.add(e2);
//        
//    	company.setEmployee(eList);
    	
    	// Adding Company Object into Employee
    	e1.setCompany(company);
    	e2.setCompany(company);
    	
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	cfg.addAnnotatedClass(Company.class);
    	cfg.addAnnotatedClass(Employee.class);
    	
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(company);
    	session.save(e1);
    	session.save(e2);
    	tran.commit();
    	session.close();
    	sf.close();
    }
}
