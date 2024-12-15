package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.*;
import service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainApp extends Application {

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

        // Layout de venda
        TextField quantidadeVendaField = new TextField();
        quantidadeVendaField.setPromptText("Quantidade de venda");

        Button realizarVendaButton = new Button("Realizar Venda");
        realizarVendaButton.setOnAction(e -> {
            try {
                Produto produto = estoque.consultarProduto("Produto Exemplo"); // O nome pode ser obtido de uma lista no futuro
                int quantidadeVenda = Integer.parseInt(quantidadeVendaField.getText());

                if (estoque.consultarProduto(produto.getNome()) != null) {
                    ItemVenda item = new ItemVenda(produto, quantidadeVenda);
                    Venda venda = new Venda(1, new Date()); // Aqui colocaria um ID de venda único e a data atual
                    venda.adicionarItem(item);
                    vendas.add(venda);
                    showAlert(Alert.AlertType.INFORMATION, "Venda Realizada", "Venda realizada com sucesso!");
                }
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
                new Text("Realizar Venda"), quantidadeVendaField, realizarVendaButton,
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
