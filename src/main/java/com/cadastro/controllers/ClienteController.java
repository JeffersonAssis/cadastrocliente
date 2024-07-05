package com.cadastro.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.Dtos.ClienteDto;
import com.cadastro.models.Cliente;
import com.cadastro.models.Endereco;
import com.cadastro.services.ClienteService;
import com.cadastro.services.EnderecoService;
import com.cadastro.utils.BindingResultValidador;

import jakarta.validation.Valid;

@RestController
@RequestMapping("cliente")
public class ClienteController {

  private EnderecoService enderecoService;
  private ClienteService clienteService;

  @Autowired
  public ClienteController(EnderecoService enderecoService, ClienteService clienteService){
    this.enderecoService = enderecoService;
    this.clienteService = clienteService;
  }

  @GetMapping("/consulta")
  public ResponseEntity<?> consultaEnderco(@RequestParam String cep){
    try{
      Endereco end =  enderecoService.consultaCep(cep);
    if(Objects.nonNull(end)){
      return ResponseEntity.ok().body(end);
    }
  }
    catch(Exception e ){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP informado, não existe!");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao consultar o CEP!");
  }

  @PostMapping("/salva")
  public ResponseEntity<?> salvarCleinte(@RequestBody @Valid Cliente cliente, BindingResult bindingResult){
    BindingResultValidador bindingResultValidador = new BindingResultValidador(bindingResult);
    if(bindingResult.hasErrors()){
      return ResponseEntity.badRequest().body(bindingResultValidador.getErrors());
    }
    try {
      Endereco end = new Endereco();
      String cep = cliente.getEndereco().getCep();
      end = enderecoService.consultaCep(cep);
      cliente.setEndereco(end);
      cliente.getEndereco().setCep(cep);
      return ResponseEntity.ok().body(clienteService.salvarCliente(cliente));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ou cadastra o cliente " + e.getMessage());
    }
    
  }
  @GetMapping("/")
  public ResponseEntity<?> obterTodosOsClientes(){
      List<ClienteDto> lDtos = clienteService.obterTodosOsClientes();  
      if(Objects.nonNull(lDtos)){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lDtos); 
      }
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body("A lista de clientes está vazia!");
  } 

}
