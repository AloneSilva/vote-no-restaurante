package br.com.vote.restaurante.util;

import junit.framework.TestCase;

public class EntityManagerHelperTester extends TestCase{

	public void testConnectionDataBase(){
		assertNotNull(EntityManagerHelper.getEntityManager());
	}
	
	public void tearDown(){
		EntityManagerHelper.getEntityManager().close();
	}
	
}
