package com.cadastro.Dtos;

import java.time.LocalDate;

public class ClienteDto {
  
  private Long id;
  private String nome; 
  private String cpf; 
  private String telefone;
  private String email;
  private LocalDate dataNasc;
  private int idade;
  

  public void setIdade(int idade) {
    this.idade = idade;
  }
  private String cep;
  private String logradouro;
  private String localidade;
  private String bairro;
  private String uf;
 
 
  public ClienteDto(Long id, String nome, String cpf, String telefone, String email, LocalDate dataNasc, int idade, String cep,
      String logradouro, String localidade, String bairro, String uf) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.email = email;
    this.dataNasc = dataNasc;
    this.idade = idade;
    this.cep = cep;
    this.logradouro = logradouro;
    this.localidade = localidade;
    this.bairro = bairro;
    this.uf = uf;
  }

  
  public ClienteDto() {
  }


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public String getTelefone() {
    return telefone;
  }
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public LocalDate getDataNasc() {
    return dataNasc;
  }
  public void setDataNasc(LocalDate dataNasc) {
    this.dataNasc = dataNasc;
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
  
  public int getIdade() {
    return idade;
  }


}
