package com.jsp.hibernate.caching.level2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		// Configure Hibernate
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();

		// Session-1
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		Product product = session.get(Product.class, 101);
		System.out.println(product);

		Product product2 = session.get(Product.class, 101);
		System.out.println(product2);

		tran.commit();
		session.close();

		System.out.println();

		// Session-2
		Session session2 = sf.openSession();
		Transaction tran2 = session2.beginTransaction();

		// Use session2
		Product product3 = session2.get(Product.class, 101);
		System.out.println(product3);

		Product product4 = session2.get(Product.class, 101);
		System.out.println(product4);

		tran2.commit();
		session2.close();

		// Close the SessionFactory
		sf.close();
	}
}
