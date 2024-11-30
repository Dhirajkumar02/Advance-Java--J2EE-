package com.jsp.hibernate.demo.car;

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
		
		Car c = session.get(Car.class, 101);
		System.out.println(c);
		
		tran.commit();
		session.close();
		sf.close();
	}

}
