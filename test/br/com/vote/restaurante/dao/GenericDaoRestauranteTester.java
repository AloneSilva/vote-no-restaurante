package br.com.vote.restaurante.dao;

import junit.framework.TestCase;
import br.com.vote.restaurante.entity.Restaurante;
import java.util.List;

public class GenericDaoRestauranteTester extends TestCase{

	private GenericDao<Restaurante> dao;
	private Restaurante r;
	
	public void setUp(){
		dao = new GenericDao<Restaurante>(Restaurante.class);
	}
	
	public void testListarRestaurante(){
		List<Restaurante> restaurantes = dao.listar();
		assertTrue(!(restaurantes.isEmpty()) && restaurantes != null);
	}
	
	public void testBuscaRestaurante(){
		r = dao.buscar(1);
		assertNotNull(r);
	}
	
	public void testSalvarRestaurante(){
		r = new Restaurante();
		r.setImagem("teste");
		r.setNome("Teste Burgers");
		boolean result = dao.salvar(r);
		
		assertTrue(result);
	}
	
	public void testAtualizarRestaurante(){
		List<Restaurante> res = dao.listar();
		Restaurante r = res.get(res.size() - 1);
		r.setNome("Teste 2");
		r = dao.atualizar(r);
		
		assertNotNull(r);
	}
	
	public void testRemoverRestaurante(){
		List<Restaurante> res = dao.listar();
		Restaurante r = res.get((res.size() - 1));
		boolean result = dao.remover(r);
		
		assertTrue(result);
	}
	
}
