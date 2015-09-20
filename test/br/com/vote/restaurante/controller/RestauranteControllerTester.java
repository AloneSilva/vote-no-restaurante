package br.com.vote.restaurante.controller;

import junit.framework.TestCase;
import java.util.List;
import br.com.vote.restaurante.entity.Restaurante;

public class RestauranteControllerTester extends TestCase{
	
	private RestauranteController controller;
	
	public void setUp(){
		controller = new RestauranteController();
	}
	
	public void testGerarNumeroAleatorioEntre0e4(){
		int numero = controller.gerarNumeroAleatorio();
		assertTrue((numero >= 0 && numero < 5));
	}
	
	public void testVerificaNumerosSorteados(){
		boolean result = controller.verificaNumeroSorteado(5);
		
		assertFalse(result);
	}
	
	public void testCriarListaAleadoria(){
		List<Restaurante> list = controller.criarListaAleadoria();
		
		assertNotNull(list);
	}
	
	public void testOrdenaRestaurantePorRanking(){
		List<Restaurante> ordenado = controller.ordenaRestaurantePorRanking();
		
		assertNotNull(ordenado);
	}

}
