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
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="EMAIL")
	@NotNull
	private String email;
	
	@Column(name="NOME")
	@NotNull
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usuario")
	private List<Ranking> rankings = new ArrayList<Ranking>();
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public List<Ranking> getRankings(){
		return this.rankings;
	}
	
	public void setRankings(List<Ranking> rankings){
		this.rankings = rankings;
	}

}
