package com.loja.services;

import com.loja.entities.Produto;
import com.loja.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProdutoServices {

    @Inject
    private ProdutoRepository produtoRepository;

    @Transactional
    public void cadastrarProduto(List<Produto> produtos) {
        for (Produto produto : produtos) {
            if (produtoRepository.hasProduto(produto.getId())) {
                try {
                    produto.persist();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
