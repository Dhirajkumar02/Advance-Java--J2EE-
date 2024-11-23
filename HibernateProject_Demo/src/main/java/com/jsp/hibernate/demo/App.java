package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Bike b = new Bike();
		b.setBikeId(101);
		b.setBikeModel("RX 100");
		b.setBikeBrand("Yamaha");
		b.setBikePrice(240000);
		
		Configuration conn = new Configuration();
		conn.configure();
		conn.addAnnotatedClass(Bike.class);
		SessionFactory sf = conn.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		session.save(b);
		
		tran.commit();
		session.close();
		sf.close();
	
		}

}
