package com.empresa.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido #" + id + "\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\nItens:\n");
        for (ItemPedido item : itens) {
            sb.append("- ").append(item).append("\n");
        }
        return sb.toString();
    }
}
