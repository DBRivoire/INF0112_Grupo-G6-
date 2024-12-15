import conteudo.Produto;

public class App {
    public static void main(String[] args) {
        try {
            // Teste de criação de um produto válido
            Produto produto1 = new Produto("Caneta", 1.0, 2.0, 100);
            System.out.println(produto1);

            // Teste de atualização de preço
            produto1.atualizarPreco(2.5);
            System.out.println("\nApós atualizar o preço:");
            System.out.println(produto1);

            // Teste de atualização de estoque (adicionando)
            produto1.atualizarEstoque(50);
            System.out.println("\nApós adicionar estoque:");
            System.out.println(produto1);

            // Teste de atualização de estoque (removendo)
            produto1.atualizarEstoque(-30);
            System.out.println("\nApós remover estoque:");
            System.out.println(produto1);

            // Teste de criação de um produto inválido
            try {
                Produto produtoInvalido = new Produto("", 1.0, 2.0, 100);
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro esperado: " + e.getMessage());
            }

            // Teste de atualização de preço inválido
            try {
                produto1.atualizarPreco(-5.0);
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro esperado ao atualizar preço: " + e.getMessage());
            }

            // Teste de atualização de estoque inválido
            try {
                produto1.atualizarEstoque(-200);
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro esperado ao atualizar estoque: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
