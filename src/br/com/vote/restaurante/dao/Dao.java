package br.com.vote.restaurante.dao;

import java.util.List;

public interface Dao<T> {

	boolean salvar(T entidade);
	T atualizar(T entidade);
	boolean remover(T entidade);
	List<T> listar();
	T buscar(int id);
	
}
