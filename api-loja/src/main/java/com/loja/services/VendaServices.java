package com.loja.services;

import com.loja.DTO.VendaDTO;
import com.loja.entities.Venda;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VendaServices {

    @Transactional
    public Integer cadastrarVenda(VendaDTO vendaDTO) {
        try {
            Venda vendaNova = new Venda(vendaDTO);
            vendaNova.persist();
            return vendaNova.getId();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
