package br.com.vote.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.vote.restaurante.entity.Usuario;
import br.com.vote.restaurante.dao.GenericDao;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Controller
public class UsuarioController {
	
	private GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
	
	@Autowired
	private UsuarioBean usuarioBean;
	
	@RequestMapping("cadastrarUsuario")
	public String salvar(@Valid Usuario usuario, BindingResult result){
		if(result.hasFieldErrors()){
			return "usuario/cadastrar";
		}
		dao.salvar(usuario);
		List<Usuario> usuarios = dao.listar();
		usuario = usuarios.get((usuarios.size() - 1));
		usuarioBean.setUsuario(usuario);
		return "redirect:atualizaRanking";
	}

}
