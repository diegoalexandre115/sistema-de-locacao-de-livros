package com.dmlc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dmlc.domain.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Integer>{

}
