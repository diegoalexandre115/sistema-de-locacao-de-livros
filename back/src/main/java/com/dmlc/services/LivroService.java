package com.dmlc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmlc.domain.Livro;
import com.dmlc.repositories.LivroRepository;
import com.dmlc.services.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repo;
	
	public Livro buscar(Integer id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> list(){
		List<Livro> list = repo.findAll();
		return list;
	}
	
}
