package br.com.vote.restaurante.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

import br.com.vote.restaurante.util.EntityManagerHelper;

public class GenericDao<T> implements Dao<T>{

	private Class classe;
	private EntityManager em;
	
	public GenericDao(Class classe){
		this.classe = classe;
	}
	
	@Override
	public boolean salvar(T entidade) {
		em = EntityManagerHelper.getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public T atualizar(T entidade) {
		em = EntityManagerHelper.getEntityManager();
		try{
			em.getTransaction().begin();
			entidade = em.merge(entidade);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
		}
		
		return entidade;
	}

	@Override
	public boolean remover(T entidade) {
		em = EntityManagerHelper.getEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(em.contains(entidade) ? entidade : em.merge(entidade));
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		return true;
	}

	@Override
	public List<T> listar() {
		em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<T> q = (TypedQuery<T>) em.createQuery("SELECT e FROM " + classe.getSimpleName() + " e");
		return q.getResultList();
	}

	@Override
	public T buscar(int id) {
		em = EntityManagerHelper.getEntityManager();
		T entidade;
		em.getTransaction().begin();
		entidade = (T) em.find(classe, id);
		return entidade;
	}
	
}
