package com.jsp.hibernate.manytoone;

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
    	company.setCompanyName("Amazon");
    	
    	Employee e1 = new Employee();
    	e1.setEmployeeId(101);
    	e1.setEmployeeName("Saurabh");
    	e1.setEmployeeSalary(35000);
    	
    	Employee e2 = new Employee();
    	e2.setEmployeeId(102);
    	e2.setEmployeeName("Dhiraj");
    	e2.setEmployeeSalary(25000);
    	
    	//Adding Employee objects into company object
    	List<Employee> eList = new ArrayList<Employee>();
    	eList.add(e1);
    	eList.add(e2);
    	company.setEmployees(eList);
    	
    	// Adding company object into employees object
    	e1.setCompany(company);
    	e2.setCompany(company);
    	
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	cfg.addAnnotatedClass(Employee.class);
    	cfg.addAnnotatedClass(Company.class);
    	
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(e1);
    	session.save(e2);
    	session.save(company);
    	tran.commit();
    	session.close();
    	sf.close();
    }
}
