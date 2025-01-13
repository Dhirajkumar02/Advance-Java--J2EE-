package com.jsp.jpa_actor_movie_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class MovieDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    

}
