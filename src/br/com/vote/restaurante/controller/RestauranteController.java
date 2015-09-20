package br.com.vote.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.Random;
import br.com.vote.restaurante.entity.Restaurante;
import br.com.vote.restaurante.dao.GenericDao;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

@Controller
public class RestauranteController {
	
	private GenericDao<Restaurante> dao = new GenericDao<Restaurante>(Restaurante.class);
	private String [] numSorteados = new String[4];
	private List<Restaurante> restSorteados;
	
	@RequestMapping("listarRestaurante")
	public String listarRestaurantesAleatorio(Model model){
		restSorteados = criarListaAleadoria();
		
		if(restSorteados.isEmpty()){
			return "usuario/cadastrar";
		}
		
		model.addAttribute("rest1", restSorteados.get(0));
		model.addAttribute("rest2", restSorteados.get(1));
		return "restaurante/votarRestaurante";
	}
	
	@RequestMapping("rakingRestaurante")
	public String listaRanking(Model model){
		List<Restaurante> ordenados = ordenaRestaurantePorRanking();
		model.addAttribute("restaurantes", ordenados);
		return "restaurante/rankingRestaurante";
	}
	
	@RequestMapping("finalizarVotacao")
	public String agradecer(HttpSession session){
		session.invalidate();
		return "agradecimento";
	}
	
	public int gerarNumeroAleatorio(){
		Random r = new Random();
		return r.nextInt(5);
	}
	
	public boolean verificaNumeroSorteado(int numero){
		
		for(int i=0; i<numSorteados.length; i++){
			if(numSorteados[i] != null && numSorteados[i].equals(String.valueOf(numero))){
				return true;
			}
		}
		return false;
	}
	
	public List<Restaurante> criarListaAleadoria(){
		List<Restaurante> restaurantes = dao.listar();
		List<Restaurante> aux = new ArrayList<Restaurante>();
		for(int i=0; i<2; i++){
			int numero = gerarNumeroAleatorio();
			while(verificaNumeroSorteado(numero)){
				numero = gerarNumeroAleatorio();
			}
			for(int j=0; j<numSorteados.length; j++){
				if(numSorteados[j] == null){
					numSorteados[j] = String.valueOf(numero);
					aux.add(restaurantes.get(numero));
					break;
				}
			}
		}
		return aux;
	}
	
	public List<Restaurante> ordenaRestaurantePorRanking(){
		List<Restaurante> res = dao.listar();
		List<Restaurante> ordenado = new ArrayList<Restaurante>();
		
		boolean add = false;
		
		for(int i=0; (i-1)<res.size(); i++){
			i=0;
			add = false;
			if(ordenado.isEmpty()){
				ordenado.add(res.get(i));
				res.remove(i);
			}else{
				for(int j=0; j<ordenado.size(); j++){
					if(ordenado.get(j).getRankings().size() < res.get(i).getRankings().size()){
						ordenado.add(j, res.get(i));
						add = !add;
						res.remove(i);
						break;
					}else if(ordenado.get(j).getRankings().size() == res.get(i).getRankings().size()){
						ordenado.add((j + 1) ,res.get(i));
						add = !add;
						res.remove(i);
						break;
					}
				}
				if(!add){
					ordenado.add(res.get(i));
					res.remove(i);
				}
			}
		}
		
		return ordenado;
	}

}
