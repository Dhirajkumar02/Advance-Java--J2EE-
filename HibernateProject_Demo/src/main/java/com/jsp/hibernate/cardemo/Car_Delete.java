package com.jsp.hibernate.cardemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Car_Delete {
	public static void main(String[] args) {
		Configuration conn = new Configuration();
		conn.configure();
		conn.addAnnotatedClass(Car.class);
		SessionFactory sf = conn.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		 
		try {
			
			Car c = new Car();
			c.setCarId(5);
			
			session.delete(c);
			tran.commit();
			System.out.println("Car details deleted successfully!");
			
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
			System.out.println("Car details not deleted!");
		}
		
		session.close();
		sf.close();
	}

}
