package com.loja.repository;

import com.loja.entities.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public boolean hasProduto(String idProduto) {
        return list("from Produto p WHERE p.id = '" + idProduto + "'").isEmpty();
    }
}
