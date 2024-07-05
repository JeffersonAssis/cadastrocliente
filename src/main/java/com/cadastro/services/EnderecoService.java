package com.cadastro.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.models.Endereco;
import com.cadastro.repositories.EnderecoRepository;

@Service
public class EnderecoService {

  @Autowired
  private ViaCep viaCep;
  @Autowired
  private EnderecoRepository enderecoRepository;

  public Endereco consultaCep(String cep){
  
      if(Objects.nonNull(cep)){
    
        Optional<Endereco> end = enderecoRepository.findById(cep);
        if(end.isPresent()){
          return end.get();
        }else{
          Endereco novEndereco = viaCep.consultaCep(cep);
          String ce = novEndereco.getCep().replace("-", "");
          novEndereco.setCep(ce);
          if(Objects.nonNull(novEndereco)){
            enderecoRepository.save(novEndereco);
            return novEndereco;
          }
        
        }
      }
     
      
    
    return null;
    
   
  }

}