package com.dmlc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	private Integer reservas;
	private Integer quantidade;
	
	@OneToMany(mappedBy="id.livro")
	private Set<LivroLocado> livroslocados = new HashSet<>();
	
	public Livro() {
	}

	public Livro(Integer id, String nome, Integer reservas, Integer quantidade, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.reservas = reservas;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public List<Locacao> getLocacoes(){
		List<Locacao> lista = new ArrayList<>();
		for(LivroLocado l :livroslocados) {
			lista.add(l.getLocacao());
		}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getReservas() {
		return reservas;
	}

	public void setReservas(Integer reservas) {
		this.reservas = reservas;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	public Set<LivroLocado> getLivroslocados() {
		return livroslocados;
	}
	
	public void setLivroslocados(Set<LivroLocado> livroslocados) {
		this.livroslocados = livroslocados;
	}
	
	
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
