package com.loja.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;

@Entity
public class Registro extends PanacheEntityBase {
    private Integer id;
    private Integer fkVenda;
    private Integer fkProduto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkVenda() {
        return fkVenda;
    }

    public void setFkVenda(Integer fkVenda) {
        this.fkVenda = fkVenda;
    }

    public Integer getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(Integer fkProduto) {
        this.fkProduto = fkProduto;
    }
}
