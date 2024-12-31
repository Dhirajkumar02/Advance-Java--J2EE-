package com.jsp.hibernate.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.jsp.hibernate.hql.Product;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Product.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        
        // select all from the product table
        NativeQuery<Product> nativeQuery = session.createNativeQuery("SELECT * FROM product WHERE productId = 102", Product.class);
        List<Product> products = nativeQuery.list();      
        for(Product product : products) {
      	System.out.println(product);
        }
        
        // For Updating the data using placeholder first method
//      NativeQuery<Product> nativeQuery = session.createNativeQuery("UPDATE Product SET productPrice=? WHERE productId=?");
//      nativeQuery.setParameter(1, 20000);
//      nativeQuery.setParameter(2, 102);
//      int rowsUpdated = nativeQuery.executeUpdate();
//      if(rowsUpdated > 0) {
//      	System.out.println(rowsUpdated+ " Data Updated Successfully!!");
//      }else {
//      	System.out.println("Data not Updated Successfully!");
//      }
      
   // Delete the data from the product table
//      Query<Product> nativeQuery = session.createQuery("DELETE FROM Product  where productId = ?1");
//      nativeQuery.setParameter(1, 102);
//      int rowsUpdated = nativeQuery.executeUpdate();
//      if(rowsUpdated > 0) {
//      	System.out.println(rowsUpdated+ " Data deleted Successfully!!");
//      }else {
//      	System.out.println("Data not deleted Successfully!");
//      }

     
     tran.commit();
     sf.close();
     session.close();

 	}

}
