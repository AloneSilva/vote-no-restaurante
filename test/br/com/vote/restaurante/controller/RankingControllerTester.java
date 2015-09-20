package br.com.vote.restaurante.controller;

import junit.framework.TestCase;
import java.util.List;
import br.com.vote.restaurante.entity.Ranking;

public class RankingControllerTester extends TestCase{
	
	private RankingController controller;
	
	public void setUp(){
		controller = new RankingController();
	}
	
	public void testGetUltimosRanking(){
		List<Ranking> r = controller.getUltimosRanking();
		
		assertEquals(2,  r.size());
	}

}
