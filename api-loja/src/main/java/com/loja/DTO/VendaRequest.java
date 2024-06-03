package com.loja.DTO;

import com.loja.entities.Venda;

import java.util.List;

public class VendaRequest {
    private VendaDTO vendaDTO;
    private List<String> produtos;

    public VendaDTO getVendaDTO() {
        return vendaDTO;
    }

    public void setVendaDTO(VendaDTO vendaDTO) {
        this.vendaDTO = vendaDTO;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }
}
