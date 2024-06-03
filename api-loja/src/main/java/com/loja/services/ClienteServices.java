package com.loja.services;

import com.loja.DTO.ClienteDTO;
import com.loja.entities.Cliente;
import com.loja.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteServices {

    @Inject
    private ClienteRepository cliente;

    public Cliente autentificarUsuario(String email, String senha) {
        return cliente.getClientePeloEmail(email, senha);
    }

    @Transactional
    public void cadastrarUsuario(ClienteDTO clienteDTO) {
        if (cliente.verificarCliente(clienteDTO.getEmail(), clienteDTO.getSenha())) {
            try {
                Cliente clienteNovo = new Cliente(clienteDTO);
                clienteNovo.persist();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
