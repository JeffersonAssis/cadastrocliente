package com.cadastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.Dtos.ClienteDto;
import com.cadastro.models.Cliente;
import com.cadastro.repositories.ClienteRepository;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  public ClienteDto salvarCliente(Cliente cliente){
    return clienteRepository.save(cliente).convertToClienteDto();
  }

  public List<ClienteDto> obterTodosOsClientes() {
    List<Cliente> listCliente = clienteRepository.findAll();
    return listCliente.stream().map(Cliente::convertToClienteDto).toList();
  }
}
