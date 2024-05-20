package com.loja;

import com.loja.entidades.Cliente;

import java.util.List;

public class ClienteServices {

    Cliente cliente;

    public Cliente autentificarUsuario(String email, String senha) {
        List<Cliente> usuario = cliente.getClientePeloEmail(email, senha);
        return usuario.getFirst();
    }

    public void cadastrarUsuario(Cliente usuarioNovo) {
        Cliente.persist(usuarioNovo);
    }
}
