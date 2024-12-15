package Application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.*;
import model.Produto;
import service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainApp_teste extends Application {

    private Estoque estoque = new Estoque();
    private List<Venda> vendas = new ArrayList<>();
    private Cafeteria cafeteria = new Cafeteria(100);
    private RelatorioVendas relatorio;

    @Override
    public void start(Stage primaryStage) {
        // Título da janela
        primaryStage.setTitle("Sistema de Vendas");

        // Layout principal
        VBox root = new VBox(10);

        // Adicionar Produto
        TextField nomeProdutoField = new TextField();
        nomeProdutoField.setPromptText("Nome do produto");
        TextField precoCustoField = new TextField();
        precoCustoField.setPromptText("Preço de Custo");
        TextField precoVendaField = new TextField();
        precoVendaField.setPromptText("Preço de Venda");
        TextField quantidadeField = new TextField();
        quantidadeField.setPromptText("Quantidade em Estoque");

        Button adicionarProdutoButton = new Button("Adicionar Produto");

        adicionarProdutoButton.setOnAction(e -> {
            try {
                String nome = nomeProdutoField.getText();
                double precoCusto = Double.parseDouble(precoCustoField.getText());
                double precoVenda = Double.parseDouble(precoVendaField.getText());
                int quantidade = Integer.parseInt(quantidadeField.getText());

                Produto produto = new Produto(nome, precoCusto, precoVenda, quantidade);
                estoque.adicionarProduto(produto);
                showAlert(Alert.AlertType.INFORMATION, "Produto Adicionado", "Produto adicionado com sucesso!");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", ex.getMessage());
            }
        });

        // Botão de Exibir Produtos
        Button exibirProdutosButton = new Button("Exibir Produtos");
        exibirProdutosButton.setOnAction(e -> estoque.listarProdutos());


        // Realizar Venda

        TextField nomeProdutoVendaField = new TextField();
        nomeProdutoVendaField.setPromptText("Nome do Produto");

        TextField quantidadeVendaField = new TextField();
        quantidadeVendaField.setPromptText("Quantidade de Venda");

        Button realizarVendaButton = new Button("Realizar Venda");
        realizarVendaButton.setOnAction(e -> {
            try {
                // Captura o nome do produto e a quantidade informados pelo usuário
                String nomeProduto = nomeProdutoVendaField.getText();
                int quantidadeVenda = Integer.parseInt(quantidadeVendaField.getText());

                // Consulta o produto no estoque pelo nome
                Produto produto = estoque.consultarProduto(nomeProduto);

                // Verifica se o produto existe e se há quantidade suficiente
                if (produto != null && produto.getQuantidadeEstoque() >= quantidadeVenda) {
                    // Cria um ItemVenda e adiciona à lista de vendas
                    ItemVenda item = new ItemVenda(produto, quantidadeVenda);
                    Venda venda = new Venda(vendas.size() + 1, new Date()); // Gera ID único baseado no tamanho da lista
                    venda.adicionarItem(item);
                    vendas.add(venda);

                    // Atualiza o estoque
                    produto.atualizarEstoque(-quantidadeVenda);

                    showAlert(Alert.AlertType.INFORMATION, "Venda Realizada", "Venda realizada com sucesso!");
                } else if (produto == null) {
                    showAlert(Alert.AlertType.ERROR, "Erro", "Produto não encontrado!");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Erro", "Quantidade insuficiente em estoque!");
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Por favor, insira valores válidos para a quantidade!");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", ex.getMessage());
            }
        });


        // Layout de Relatório
        Button gerarRelatorioButton = new Button("Gerar Relatório");
        gerarRelatorioButton.setOnAction(e -> {
            try {
                relatorio = new RelatorioVendas(vendas, new Date(), new Date()); // Período do relatório
                relatorio.gerarRelatorio();
                showAlert(Alert.AlertType.INFORMATION, "Relatório Gerado", relatorio.toString());
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", ex.getMessage());
            }
        });

        // Layout principal
        root.getChildren().addAll(
                new Text("Cadastro de Produtos"), nomeProdutoField, precoCustoField, precoVendaField, quantidadeField, adicionarProdutoButton,
                exibirProdutosButton,
                new Text("Realizar Venda"), nomeProdutoVendaField, quantidadeVendaField, realizarVendaButton,
                gerarRelatorioButton
        );

        // Cena e exibição
        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para exibir alertas
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
