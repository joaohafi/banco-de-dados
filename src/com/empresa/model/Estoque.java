package com.empresa.model;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Produto, Integer> produtos = new HashMap<>();

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.put(produto, produtos.getOrDefault(produto, 0) + quantidade);
    }

    public Produto getProdutoPorId(int id) {
        for (Produto p : produtos.keySet()) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Estoque:\n");
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            sb.append(entry.getKey())
              .append(" | Quantidade: ").append(entry.getValue())
              .append("\n");
        }
        return sb.toString();
    }
}
