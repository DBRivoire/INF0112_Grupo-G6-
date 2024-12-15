// Classe estoque

package service;

import model.Produto;
import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Produto> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    // Adicionar um produto ao estoque
    public void adicionarProduto(Produto produto) {
        if (produtos.containsKey(produto.getNome())) {
            throw new IllegalArgumentException("Produto já existe no estoque!");
        }
        produtos.put(produto.getNome(), produto);
    }

    // Remover um produto do estoque
    public void removerProduto(String nomeProduto) {
        if (!produtos.containsKey(nomeProduto)) {
            throw new IllegalArgumentException("Produto não encontrado no estoque!");
        }
        produtos.remove(nomeProduto);
    }

    // Consultar um produto pelo nome
    public Produto consultarProduto(String nomeProduto) {
        return produtos.get(nomeProduto);
    }

    // Atualizar estoque de um produto pelo nome
    public void atualizarEstoqueProduto(String nomeProduto, int quantidade) {
        Produto produto = produtos.get(nomeProduto);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado no estoque!");
        }
        produto.atualizarEstoque(quantidade);
    }

    // Listar todos os produtos no estoque
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
            return;
        }
        System.out.println("Produtos no estoque:");
        for (Produto produto : produtos.values()) {
            System.out.println(produto);
        }
    }
}