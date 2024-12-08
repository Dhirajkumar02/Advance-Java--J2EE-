package com.jsp.spring.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class App 
{
    public static void main( String[] args )
    {
        BeanFactory bf = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        
        // 1st Way to create Object
        Student s = bf.getBean(Student.class);
        s.learn();
        
        // 2nd Way to create Object
        Student s2 = (Student) bf.getBean("student-bean");
        s2.learn();
    }
}
