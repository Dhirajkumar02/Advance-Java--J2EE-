package com.jsp.spring.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsp.spring.annotations.Product;

public class App 
{
    public static void main( String[] args )
    {
    	// 50% Annotation based Configuration
    	
//    	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//    	Product product = ac.getBean(Product.class);
//    	System.out.println(product);
//    	
//    	Product product2 = (Product)ac.getBean("product");
//    	System.out.println(product2);
    	
    	// 100% Annotation based Configuration
    	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    	Product p1 = ac.getBean(Product.class);
    	System.out.println(p1);
    	
    	Product p2 = (Product) ac.getBean("product");
    	System.out.println(p2);
    }
}
