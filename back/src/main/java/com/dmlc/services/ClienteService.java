package com.dmlc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmlc.domain.Cliente;
import com.dmlc.repositories.ClienteRepository;
import com.dmlc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> list(){
		List<Cliente> list = repo.findAll();
		return list;
	}

}
