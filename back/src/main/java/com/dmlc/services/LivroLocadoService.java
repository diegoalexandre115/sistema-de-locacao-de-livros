package com.dmlc.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmlc.domain.Livro;
import com.dmlc.domain.LivroLocado;
import com.dmlc.domain.LivroLocadoPK;
import com.dmlc.domain.Locacao;
import com.dmlc.repositories.LivroLocadoRepository;
import com.dmlc.services.exception.ObjectNotFoundException;

@Service
public class LivroLocadoService {
	
	@Autowired
	private LivroLocadoRepository repo;
	
	
	
	public LivroLocado buscar(Integer id) {
		Optional<LivroLocado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", Tipo: " + LivroLocado.class.getName()));
	}
	
	public List<LivroLocado> list(){
		List<LivroLocado> list = repo.findAll();
		return list;
	}
	
	public List<Livro> livrosLocados(){
		List<LivroLocado> list = repo.findAll();
		List<Livro> livros = new ArrayList<>();
		for(LivroLocado l: list) {
			livros.add(l.getLivro());
			
		}
		return livros;
	}
	
	public List<LivroLocado> locadosSemana(){
		List<LivroLocado> list = repo.findAll();
		
		Date date = new Date();
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		Integer year1 = cal1.get(Calendar.YEAR);
		Integer week1 = cal1.get(Calendar.WEEK_OF_YEAR);
		
		Calendar cal2 = Calendar.getInstance();
		Integer year2 = 0;
		Integer week2 = 0;
		
		for(LivroLocado l: list) {
			cal2.setTime(l.getLocacao().getDataDoAluguel());
			year2 = cal2.get(Calendar.YEAR);
			week2 = cal2.get(Calendar.WEEK_OF_YEAR);
			
			if(year1 != year2) {
				list.remove(l);
				
			}
			else {
				if(week1!=week2){
					list.remove(l);
					
				}
			}
			
		}
		return list;
		
	}
	
	public List<LivroLocado> devolvidosSemana(){
		List<LivroLocado> list = repo.findAll();
		
		
		Date date = new Date();
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		Integer year1 = cal1.get(Calendar.YEAR);
		Integer week1 = cal1.get(Calendar.WEEK_OF_YEAR);
		
		Calendar cal2 = Calendar.getInstance();
		Integer year2 = 0;
		Integer week2 = 0;
		for(LivroLocado l: list) {
			cal2.setTime(l.getLocacao().getDataDeDevolução());
			year2 = cal2.get(Calendar.YEAR);
			week2 = cal2.get(Calendar.WEEK_OF_YEAR);
			
			if(year1 != year2) {
				list.remove(l);
				
			}
			else {
				if(week1!=week2){
					list.remove(l);
					
				}
			}
			
		}
		return list;
		
	}
	public LivroLocado reservaLivro(Livro livro, Locacao locacao) {
		LivroLocado livrolocado = new LivroLocado();
		LivroLocadoPK livrolocadopk = new LivroLocadoPK();
		
		livrolocadopk.setLivro(livro);
		livrolocadopk.setLocacao(locacao);
		
		if((livro.getQuantidade()-livro.getReservas()) > 0) {
			livro.setReservas(livro.getReservas()+1);
			
			livrolocado.setId(livrolocadopk);
			livrolocado.setPreco(livro.getPreco());
			livrolocado.setQuantidade(1);
			repo.save(livrolocado);
		}
		return livrolocado;
		
	}
	public List<LivroLocado> devolveLivro( LivroLocadoPK id) {
		List<LivroLocado> livros = repo.findAll();
		for(LivroLocado liv : livros) {
			if(liv.getId() == id) {
				id.getLivro().setReservas(id.getLivro().getReservas()-1);
				livros.remove(liv);
				repo.delete(liv);
			}
		}
		return livros;
		
	}

}
