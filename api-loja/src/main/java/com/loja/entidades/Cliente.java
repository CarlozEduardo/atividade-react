package com.loja.entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Cliente extends PanacheEntity {

    @Id
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String CPF;

    public Cliente(String nome, String email, String senha, String CPF) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.CPF = CPF;
    }

    public List<Cliente> getClientePeloEmail(String email, String senha) {
        return list("from Cliente c " + "where c.email == " + email + "AND c.senha == " + senha);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
