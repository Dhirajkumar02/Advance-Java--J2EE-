package com.jsp.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jsp.hibernate.hql.Product;

public class Criteria_App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Product.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Product.class);
        criteria.setProjection(Projections.property("ProductId"));
//        criteria.add(Restrictions.eq("productId", 101));
//        criteria.add(Restrictions.gt("productId", 102));
//        criteria.add(Restrictions.lt("productId", 101));
//        criteria.add(Restrictions.between("productId", 101, 104));
//        criteria.add(Restrictions.like("productName", "Jeans"));
//        criteria.add(Restrictions.isNotNull("productId"));
        
        List<Integer> products = criteria.list();
        for(int product : products) {
        	System.out.println(product);
        }
        
        tran.commit();
        session.close();
        sf.close();

		
	}

}
