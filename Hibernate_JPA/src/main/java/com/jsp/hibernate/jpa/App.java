package com.jsp.hibernate.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	Movie m = new Movie();
    	m.setMovieId(101);
    	m.setMovieReleasedDate("21/12/2018");
    	m.setMovieName("KGF");
    	m.setMovieActorName("Yash");
    	m.setMovieDirectorName("Prashanth Neel");
    	m.setMovieType("Action/Thriller");
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        
//        em.persist(m);
        System.out.println(em.find(Movie.class, 102));
        et.commit();
        em.close();
        emf.close();
    }
}
