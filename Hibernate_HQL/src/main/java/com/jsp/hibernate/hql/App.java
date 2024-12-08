package com.jsp.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Product.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        
        //Select all from the Product table
//        Query<Product> query = session.createQuery("FROM Product");
//        List<Product> products = query.list();
//        for(Product product : products) {
//        	System.out.println(product);
//        }
        
        // For Updating the data using placeholder first method
//        Query<Product> query = session.createQuery("UPDATE Product p SET p.productPrice=?1 WHERE p.productId=?2");
//        query.setParameter(1, 80000);
//        query.setParameter(2, 102);
//        int rowsUpdated = query.executeUpdate();
//        if(rowsUpdated > 0) {
//        	System.out.println(rowsUpdated+ " Data Updated Successfully!!");
//        }else {
//        	System.out.println("Data not Updated Successfully!");
//        }
        
        // Using placeholder second method 
//        Query<Product> query = session.createQuery("UPDATE Product p SET p.productPrice = :firstId WHERE p.productId =:lastId");
//        query.setParameter("firstId", 90000);
//        query.setParameter("lastId", 102);
//        int rowsUpdated = query.executeUpdate();
//        if(rowsUpdated > 0) {
//        	System.out.println(rowsUpdated+ " Data Updated Successfully!!");
//        }else {
//        	System.out.println("Data not Updated Successfully!");
//        }
        
        // Delete the data from the product table
        Query<Product> query = session.createQuery("DELETE FROM Product p where p.productId = ?1");
        query.setParameter(1, 102);
        int rowsUpdated = query.executeUpdate();
        if(rowsUpdated > 0) {
        	System.out.println(rowsUpdated+ " Data deleted Successfully!!");
        }else {
        	System.out.println("Data not deleted Successfully!");
        }
        
        tran.commit();
        sf.close();
        session.close();
        
    }
}
