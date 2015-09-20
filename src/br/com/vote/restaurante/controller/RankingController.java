package br.com.vote.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.vote.restaurante.entity.Restaurante;
import br.com.vote.restaurante.entity.Ranking;
import br.com.vote.restaurante.entity.Usuario;
import br.com.vote.restaurante.dao.GenericDao;
import java.util.List;
import java.util.ArrayList;

@Controller
public class RankingController {
	
	private GenericDao<Ranking> dao = new GenericDao<Ranking>(Ranking.class);
	private List<Ranking> rankingSalvo = new ArrayList<Ranking>();
	
	@Autowired
	private UsuarioBean usuarioBean;
	
	@RequestMapping("cadastrarRanking")
	public String salvar(Restaurante restaurante){
		Ranking ranking = new Ranking();
		ranking.setRestaurante(restaurante);
		dao.salvar(ranking);
		return "redirect:listarRestaurante";
	}
	
	@RequestMapping("atualizaRanking")
	public String atualizarRanking(){
		this.rankingSalvo = getUltimosRanking();
		Usuario usuario = usuarioBean.getUsuario();
		
		for(Ranking r : rankingSalvo){
			r.setUsuario(usuario);
			dao.atualizar(r);
		}
		
		return "redirect:rakingRestaurante";
	}
	
	public List<Ranking> getUltimosRanking(){
		List<Ranking> ranking = dao.listar();
		List<Ranking> selecionado = new ArrayList<Ranking>();
		
		for(int i=0; i<2; i++){
			selecionado.add(ranking.get((ranking.size() - (i+1))));
		}
		return selecionado;
	}
	
}
