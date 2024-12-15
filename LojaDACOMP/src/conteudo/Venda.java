package conteudo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private final int idVenda; // Identificação única da venda
    private final Date dataVenda; // Data em que a venda foi realizada
    private final List<ItemVenda> itens; // Lista de itens vendidos
    private double totalVenda; // Total da venda (calculado dinamicamente)

    // Construtor
    public Venda(int idVenda, Date dataVenda) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.itens = new ArrayList<>();
        this.totalVenda = 0.0;
    }

    // Adiciona um item à lista de itens da venda
    public void adicionarItem(ItemVenda item) {
        itens.add(item);
        calcularTotalVenda(); // Recalcula o total da venda sempre que um item é adicionado
    }

    // Calcula o total da venda somando os totais de todos os itens
    private void calcularTotalVenda() {
        totalVenda = 0.0;
        for (ItemVenda item : itens) {
            totalVenda += item.calcularTotal();
        }
    }

    // Getters
    public int getIdVenda() {
        return idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    // Método para exibir detalhes da venda
    @Override
    public String toString() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Venda ID: ").append(idVenda).append("\n");
        detalhes.append("Data: ").append(dataVenda).append("\n");
        detalhes.append("Itens Vendidos:\n");

        for (ItemVenda item : itens) {
            detalhes.append(item.toString()).append("\n");
        }

        detalhes.append("Total da Venda: R$ ").append(totalVenda);
        return detalhes.toString();
    }
}