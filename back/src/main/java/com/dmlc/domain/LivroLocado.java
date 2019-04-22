package com.dmlc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class LivroLocado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private LivroLocadoPK id = new LivroLocadoPK();
	private Integer quantidade;
	private Double preco;
	
	public LivroLocado() {
	}

	public LivroLocado(Livro livro,Locacao locacao, Integer quantidade, Double preco) {
		super();
		id.setLivro(livro);
		id.setLocacao(locacao);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Locacao getLocacao() {
		return id.getLocacao();
	}
	
	public Livro getLivro() {
		return id.getLivro();
	}
	
	public LivroLocadoPK getId() {
		return id;
	}

	public void setId(LivroLocadoPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		LivroLocado other = (LivroLocado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
