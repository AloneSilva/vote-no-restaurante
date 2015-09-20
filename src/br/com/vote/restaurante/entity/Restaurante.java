package br.com.vote.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="RESTAURANTE")
public class Restaurante implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="IMAGEM")
	private String imagem;
	
	@Transient
	private int qdtVotos;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="restaurante")
	private List<Ranking> rankings = new ArrayList<Ranking>();
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getImagem(){
		return this.imagem;
	}
	
	public void setImagem(String imagem){
		this.imagem = imagem;
	}
	
	public List<Ranking> getRankings(){
		return this.rankings;
	}
	
	public void setRankings(List<Ranking> rankings){
		this.rankings = rankings;
	}
	
	public int getQdtVotos(){
		this.setQdtVotos(this.getRankings().size());
		return this.qdtVotos;
	}
	
	private void setQdtVotos(int qdtVotos){
		this.qdtVotos = qdtVotos;
	}

}
