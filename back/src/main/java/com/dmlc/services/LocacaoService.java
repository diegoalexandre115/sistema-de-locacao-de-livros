package com.dmlc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmlc.domain.Locacao;
import com.dmlc.repositories.LocacaoRepository;
import com.dmlc.services.exception.ObjectNotFoundException;

@Service
public class LocacaoService {
	@Autowired
	private LocacaoRepository repo;
	
	public Locacao buscar(Integer id) {
		Optional<Locacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", Tipo: " + Locacao.class.getName()));
	}
	
	public List<Locacao> list(){
		List<Locacao> list = repo.findAll();
		return list;
	}
	/*public void addReserva() {
		
	}*/

}
