package com.cadastro.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cadastro.models.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCep {

  @GetMapping("/{cep}/json/")
  Endereco consultaCep(@PathVariable("cep") String cep);
  
}