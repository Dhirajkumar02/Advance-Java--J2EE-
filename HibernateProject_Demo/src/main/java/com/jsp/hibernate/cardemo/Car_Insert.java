package com.jsp.hibernate.cardemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Car_Insert {
	public static void main(String[] args) {
//		Car c1 = new Car();
//		c1.setCarName("Civica");
//		c1.setCarBrand("Honda");
//		c1.setCarPrice(270000);
		
//		Car c2 = new Car();
//		c2.setCarName("Maruti Suzuki");
//		c2.setCarBrand("Mahindra");
//		c2.setCarPrice(360000);
		
		Car c3 = new Car();
		c3.setCarName("Neono");
		c3.setCarBrand("TATA");
		c3.setCarPrice(250000);
		
		Configuration conn = new Configuration();
		conn.configure();
		conn.addAnnotatedClass(Car.class);
		SessionFactory sf = conn.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		 
		try {
			session.save(c3);
			tran.commit();
			System.out.println("Car details inserted successfully!");
			
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
			System.out.println("Car details not inserted!");
		}
		
		session.close();
		sf.close();
	
		}

}
