package com.loja.services;

import com.loja.entities.Produto;
import com.loja.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProdutoServices {

    @Inject
    private ProdutoRepository produtoRepository;

    @Transactional
    public void cadastrarProduto(Produto produto) {
        if (produtoRepository.hasProduto(produto.getId())) {
            try {
                produto.persist();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
