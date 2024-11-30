package com.jsp.hibernate.demo.car;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Car_Insert {
	public static void main(String[] args) {
		Car c = new Car();
		c.setCarId(101);
		c.setCarName("Civica");
		c.setCarBrand("Honda");
		c.setCarPrice(270000);
		
		Configuration conn = new Configuration();
		conn.configure();
		conn.addAnnotatedClass(Car.class);
		SessionFactory sf = conn.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		 
		session.save(c);
		
		tran.commit();
		session.close();
		sf.close();
	
		}

}
