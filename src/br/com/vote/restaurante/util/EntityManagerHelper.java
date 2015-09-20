package br.com.vote.restaurante.util;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

public class EntityManagerHelper {
	
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vote-no-restaurante");
		entityManager = emf.createEntityManager();
		return entityManager;
	}
	
}
