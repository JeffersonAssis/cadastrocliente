package com.cadastro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "endereco")
public class Endereco {
  
  @NotBlank
  @NotBlank
  @Pattern(regexp = "[0-9]+", message = "Só é permitido cpf números")
  @Id
  private String cep;

  private String logradouro;
  
  private String localidade;
  
  private String bairro;
  
  private String uf;

  public Endereco(){}

  public Endereco(String cep, String logradouro, String localidade, String bairro, String uf) {
    this.cep = cep;
    this.logradouro = logradouro;
    this.localidade = localidade;
    this.bairro = bairro;
    this.uf = uf;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  

}
