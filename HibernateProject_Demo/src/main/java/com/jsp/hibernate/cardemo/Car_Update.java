package com.jsp.hibernate.cardemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Car_Update {
	public static void main(String[] args) {
		Configuration conn = new Configuration();
		conn.configure();
		conn.addAnnotatedClass(Car.class);
		SessionFactory sf = conn.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		 
		
		try {
			// fetching the data from the database
			Car c = session.get(Car.class, 1);
			c.setCarName("Civica");
			c.setCarPrice(3500000);
			
			// Updating the data inside the database
			session.saveOrUpdate(c);
			tran.commit();
			System.out.println("Car details Updated successfully!");
			
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
			System.out.println("Car details not Updated!");
		}
		
		session.close();
		sf.close();
	}

}
