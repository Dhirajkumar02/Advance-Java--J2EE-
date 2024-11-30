package com.jsp.hibernate.manytomanybidirectional;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Student s1 = new Student();
    	s1.setStudentId(101);
    	s1.setStudentName("Dhiraj");
    	
    	Student s2 = new Student();
    	s2.setStudentId(102);
    	s2.setStudentName("Sazid");
    	
    	Course c1 = new Course();
    	c1.setCourseId(1);
    	c1.setCourseName("JFS");
    	c1.setCourseFee(35000);
    	
    	Course c2 = new Course();
    	c2.setCourseId(2);
    	c2.setCourseName("PFS");
    	c2.setCourseFee(32000);
    	
    	// Adding courses into student
    	List<Course> cList = new ArrayList<Course>();
    	cList.add(c1);
    	cList.add(c2);
    	
    	s1.setCourses(cList);
    	s2.setCourses(cList);
    	
//    	// Adding students into courses
//    	List<Student> sList = new ArrayList<Student>();
//    	sList.add(s1);
//    	sList.add(s2);
//    	
//    	c1.setStudents(sList);
//    	c2.setStudents(sList);
    	
    	Configuration cfg = new Configuration().configure()
    			.addAnnotatedClass(Student.class)
    			.addAnnotatedClass(Course.class);
    	
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(s1);
    	session.save(s2);
    	session.save(c1);
    	session.save(c2);
    	tran.commit();
    	session.close();
    	sf.close();
    	
    }
}