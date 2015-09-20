package br.com.vote.restaurante.controller;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import br.com.vote.restaurante.entity.Usuario;

@Component
@Scope("singleton")
public class UsuarioBean {

	private Usuario usuario;
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
}
