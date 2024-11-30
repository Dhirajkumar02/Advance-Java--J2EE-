package com.jsp.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
//    	Person p = new Person();
//    	p.setPersonId(101);
//    	p.setPersonName("Dhiraj");
//    	
//    	Aadhar a = new Aadhar();
//    	a.setAadharId(1);
//    	a.setAadharNo(786836088878l);
//    	
//    	// Adding aadhar object inside person object
//    	p.setAadhar(a);
    	
    	// Adding person object inside aadhar object
    	//a.setPerson(p);
    	
   
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	cfg.addAnnotatedClass(Person.class);
    	cfg.addAnnotatedClass(Aadhar.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	Person person = session.get(Person.class, 101);
    	System.out.println(person.getPersonId());
    	System.out.println(person.getPersonName());
    	System.out.println(person.getAadhar().getAadharId());
    	System.out.println(person.getAadhar().getAadharNo());
    	
//    	session.save(p);
//    	session.save(a);
    	tran.commit();
    	session.close();
    	sf.close();
    }
}
