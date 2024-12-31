package com.jsp.hibernate.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.hql.Product;

public class CriteriaBuilder_App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		// Fetch Query

		//        CriteriaBuilder cb = session.getCriteriaBuilder();
		//        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		//        Root<Product> root =  cq.from(Product.class);
		//		          cq.select(root);
		//        cq.select(root.get("productBrand"));
		//        cq.where(cb.equal(root.get("productId"), 101));
		//        cq.where(cb.gt(root.get("productId"), 101));
		//        cq.where(cb.between(root.get("productId"), 101, 101));
		//        cq.where(cb.like(root.get("productId"), "Apple"));
		
		//        Query<Product> query = session.createQuery(cq);
		//        List<Product> products = query.list();
		//        for(Product product : products) {
		//        	System.out.println(product);
		//        }

		// Update Query

		//        CriteriaBuilder cb = session.getCriteriaBuilder();
		//        CriteriaUpdate<Product> cu = cb.createCriteriaUpdate(Product.class);
		//        Root<Product> root = cu.from(Product.class);
		//        cu.set(root.get("productPrice"), 20000);
		//        cu.where(cb.equal(root.get("productId"), 101));
		//        
		//        Query<Product> query = session.createQuery(cu);
		//        int rowsUpdated = query.executeUpdate();
		//        if(rowsUpdated > 0) {
		//        	System.out.println(rowsUpdated + " Data Updated Successfully!");
		//        }else {
		//			System.out.println("Data not updated Successfully!");
		//		}

		// Delete Query using CriteriaBuilder
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Product> cd = cb.createCriteriaDelete(Product.class);
		Root<Product> root = cd.from(Product.class);
		cd.where(cb.lt(root.get("productPrice"), 20000));

		Query<Product> query = session.createQuery(cd);
		int rowsDeleted = query.executeUpdate();
		if(rowsDeleted > 0) { 
			System.out.println(rowsDeleted + " Data Deleted Successfully!");
		}else {
			System.out.println("Data not Deleted Successfully!");
		}


		tran.commit();
		session.close();
		sf.close();
	}


}
