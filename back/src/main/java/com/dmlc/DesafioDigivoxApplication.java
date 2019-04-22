package com.dmlc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dmlc.domain.Cliente;
import com.dmlc.domain.Livro;
import com.dmlc.repositories.ClienteRepository;
import com.dmlc.repositories.LivroLocadoRepository;
import com.dmlc.repositories.LivroRepository;
import com.dmlc.repositories.LocacaoRepository;

@SpringBootApplication
public class DesafioDigivoxApplication implements CommandLineRunner{

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private LocacaoRepository produtoRepository;

	@Autowired
	private LivroLocadoRepository livroLocadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioDigivoxApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Livro l1 = new Livro(null,"Senhor dos Anéis",0,5,20.0);
		Livro l2 = new Livro(null,"Guia do mochileiro das galáxias",0,1,50.0);
		Livro l3 = new Livro(null,"Prequeno Príncipe",0,3,30.0);
		
		Cliente c1 = new Cliente(null,"Lucas Lima");
		Cliente c2 = new Cliente(null,"Marilia Karla");
		
		livroRepository.saveAll(Arrays.asList(l1,l2,l3));
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		
	}

	
	
}
