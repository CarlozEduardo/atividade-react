package com.loja.entities;

import com.loja.DTO.VendaDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Venda extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dtVenda;
    private Double precoTotal;
    private Integer fkCliente;

    public Venda(){}
    public Venda(VendaDTO vendaDTO) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        this.dtVenda = currentDateTime;
        this.precoTotal = vendaDTO.getPrecoTotal();
        this.fkCliente = vendaDTO.getFkCliente();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return dtVenda;
    }

    public void setData(LocalDateTime data) {
        this.dtVenda = data;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Integer getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Integer fkCliente) {
        this.fkCliente = fkCliente;
    }
}
