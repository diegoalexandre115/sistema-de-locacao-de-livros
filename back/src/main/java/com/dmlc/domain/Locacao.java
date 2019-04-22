package com.dmlc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Locacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date dataDeDevolução;
	private Date dataDoAluguel;
	private Date dataDaReserva;
	private Integer tipo;
	
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy="id.locacao")
	private Set<LivroLocado> livroslocados = new HashSet<>();
	
	public Locacao() {
	}

	public Locacao(Integer id, Date dataDeDevolução, Date dataDoAluguel, Date dataDaReserva, Integer tipo) {
		super();
		this.id = id;
		this.dataDeDevolução = dataDeDevolução;
		this.dataDoAluguel = dataDoAluguel;
		this.dataDaReserva = dataDaReserva;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataDeDevolução() {
		return dataDeDevolução;
	}

	public void setDataDeDevolução(Date dataDeDevolução) {
		this.dataDeDevolução = dataDeDevolução;
	}

	public Date getDataDoAluguel() {
		return dataDoAluguel;
	}

	public void setDataDoAluguel(Date dataDoAluguel) {
		this.dataDoAluguel = dataDoAluguel;
	}

	public Date getDataDaReserva() {
		return dataDaReserva;
	}

	public void setDataDaReserva(Date dataDaReserva) {
		this.dataDaReserva = dataDaReserva;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Set<LivroLocado> getLivroslocados() {
		return livroslocados;
	}
	
	public void setLivroslocados(Set<LivroLocado> livroslocados) {
		this.livroslocados = livroslocados;
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
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
