package com.dmlc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmlc.domain.LivroLocado;

@Repository
public interface LivroLocadoRepository extends JpaRepository<LivroLocado, Integer>{

}
