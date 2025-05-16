package com.empresa.model;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private String nome;
    private BigDecimal preco;

    public Produto(int id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", preco=" + preco +
               '}';
    }
}
