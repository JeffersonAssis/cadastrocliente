package com.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,String>{
  
}
