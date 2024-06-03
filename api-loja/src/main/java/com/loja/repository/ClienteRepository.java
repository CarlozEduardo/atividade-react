package com.loja.repository;

import com.loja.entities.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public Cliente getClientePeloEmail(String email, String senha) {
        return find("from Cliente c WHERE c.email = '" + email + "' AND c.senha = '" + senha + "'").firstResult();
    }

    public boolean verificarCliente(String email, String senha) {
        return list("from Cliente c WHERE c.email = '" + email + "' AND c.senha = '" + senha + "'").isEmpty();
    }
}
