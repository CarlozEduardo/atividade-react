package com.loja.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.eclipse.microprofile.reactive.streams.operators.ReactiveStreams;

@Entity
public class Registro extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer fkVenda;
    private String fkProduto;

    public Registro(){}
    public Registro(Integer fkVenda, String fkProduto) {
        this.fkVenda = fkVenda;
        this.fkProduto = fkProduto;
    }

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

    public String getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(String fkProduto) {
        this.fkProduto = fkProduto;
    }
}
