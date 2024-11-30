package com.jsp.hibernate.cardemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Car_Fetch {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Car.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		Car c = session.get(Car.class, 4);
		
		if (c != null) {
			System.out.println(c);
		} else {
			System.out.println("Car Details not found!");

		}
		
		session.close();
		sf.close();
	}

}
