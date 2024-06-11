package com.loja.services;

import com.loja.entities.Registro;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RegistroServices {

    @Transactional
    public void  associarProdutoComVenda(Integer idVenda, List<String> produtoList) {
        for (String idProduto : produtoList) {
            try {
                Registro registroNovo = new Registro(idVenda, idProduto);
                registroNovo.persist();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
