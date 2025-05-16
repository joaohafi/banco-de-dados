package com.empresa;

import com.empresa.model.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static Estoque estoque = new Estoque();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Adicionar produto ao estoque");
            System.out.println("2. Ver estoque");
            System.out.println("3. Criar cliente e pedido");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> System.out.println(estoque);
                case 3 -> criarPedido();
                case 4 -> executando = false;
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void adicionarProduto() {
        System.out.print("ID do Produto: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do Produto: ");
        BigDecimal preco = new BigDecimal(scanner.nextLine());
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        Produto produto = new Produto(id, nome, preco);
        estoque.adicionarProduto(produto, quantidade);
        System.out.println("Produto adicionado ao estoque.");
    }

    private static void criarPedido() {
        System.out.print("ID do Cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(idCliente, nomeCliente);

        Pedido pedido = new Pedido(1, cliente);

        while (true) {
            System.out.print("ID do Produto a adicionar (ou 0 para finalizar): ");
            int idProduto = Integer.parseInt(scanner.nextLine());
            if (idProduto == 0) break;

            Produto encontrado = estoque.getProdutoPorId(idProduto);
            if (encontrado == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            System.out.print("Quantidade: ");
            int qtd = Integer.parseInt(scanner.nextLine());
            pedido.adicionarItem(new ItemPedido(encontrado, qtd));
        }

        System.out.println("Pedido criado:\n" + pedido);
    }
}
