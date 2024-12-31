package com.jsp.spring.autowire;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class AutowireByName 
{
    public static void main( String[] args )
    {
    	BeanFactory bf = new XmlBeanFactory(new FileSystemResource("autowire-byName.xml"));
    	 Student s = bf.getBean(Student.class);
    	 System.out.println(s);
    	 System.out.println(s.getAddress());
    }
}