package com.cadastro.models;

import java.time.LocalDate;
import java.time.Period;

import com.cadastro.Dtos.ClienteDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size( min = 4, max = 70)
  @Column(nullable = false)
  private String nome; 

  @NotBlank
  @Pattern(regexp = "[0-9]+", message = "Só é permitido cpf números")
  @Size(min = 11, max =12, message = "Tem que conter 11 caracteres")
  @Column(unique = true, nullable = false)
  private String cpf; 

  @NotBlank
  @Pattern(regexp = "[0-9]+", message = "Só é permitido telefone números")
  @Size(min = 9, max =11, message = "Tem que conter no maximo 11 caracteres")
  @Column(nullable = false)
  private String telefone;
  
  @Email
  @Column(unique = true, nullable = false)
  private String email;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @Column(nullable = false, name = "data_nasc")
  private LocalDate dataNasc;
 
 @ManyToOne
 private Endereco endereco;

public Cliente() {
}

public Cliente(Long id, String nome, String cpf, String telefone, String email, LocalDate data_nasc, Endereco endereco) {
  this.id = id;
  this.nome = nome;
  this.cpf = cpf;
  this.telefone = telefone;
  this.email = email;
  this.dataNasc = data_nasc;
  this.endereco = endereco;
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

public LocalDate getData_nasc() {
  return dataNasc;
}

public void setData_nasc(LocalDate data_nasc) {
  this.dataNasc = data_nasc;
}

public Endereco getEndereco() {
  return endereco;
}

public void setEndereco(Endereco endereco) {
  this.endereco = endereco;
}
 

  public ClienteDto convertToClienteDto(){
    ClienteDto cDto = new ClienteDto();

    cDto.setId(id);
    cDto.setCpf(cpf);
    cDto.setCep(endereco.getCep());
    cDto.setBairro(endereco.getBairro());
    cDto.setDataNasc(dataNasc);
    cDto.setEmail(email);
    cDto.setLocalidade(endereco.getLocalidade());
    cDto.setLogradouro(endereco.getLogradouro());
    cDto.setNome(nome);
    cDto.setTelefone(telefone);
    cDto.setUf(endereco.getUf());
    cDto.setIdade(getIdade());
    return cDto;
  }

  private int getIdade(){

    LocalDate hoje = LocalDate.now();
    Period period = Period.between(dataNasc, hoje );

    return period.getYears();
  }
}
