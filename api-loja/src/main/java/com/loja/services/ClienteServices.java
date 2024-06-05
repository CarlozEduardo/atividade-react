package com.loja.services;

import com.loja.DTO.ClienteDTO;
import com.loja.entities.Cliente;
import com.loja.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotAuthorizedException;

@ApplicationScoped
public class ClienteServices {

    @Inject
    private ClienteRepository clienteRepository;

    public Cliente autentificarUsuario(String email, String senha) {
        Cliente cliente = clienteRepository.getClientePeloEmail(email, senha);
        if (cliente == null) {
            throw new NotAuthorizedException("Email ou senha inválidos");
        }
        return cliente;
    }

    @Transactional
    public void cadastrarUsuario(ClienteDTO clienteDTO) {
        if (clienteRepository.verificarCliente(clienteDTO.getEmail(), clienteDTO.getSenha())) {
            try {
                Cliente clienteNovo = new Cliente(clienteDTO);
                clienteNovo.persist();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
