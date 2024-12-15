//Classe RelatorioVendas

package service;

import model.Venda;
import model.Produto;
import model.ItemVenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioVendas {
    private final List<Venda> vendas; // Lista de vendas incluídas no relatório
    private final Date dataInicio; // Data de início do período do relatório
    private final Date dataFim; // Data de fim do período do relatório
    private Produto produtoMaisVendido; // Produto mais vendido no período
    private List<Date> diasMaisMovimento; // Dias com maior número de vendas
    private double totalVendas; // Total de vendas no período

    // Construtor
    public RelatorioVendas(List<Venda> vendas, Date dataInicio, Date dataFim) {
        this.vendas = vendas;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.produtoMaisVendido = null;
        this.diasMaisMovimento = new ArrayList<>();
        this.totalVendas = 0.0;
    }

    // Gera o relatório, calculando os atributos principais
    public void gerarRelatorio() {
        calcularTotalVendas();
        produtoMaisVendido = calcularProdutoMaisVendido();
        diasMaisMovimento = calcularDiasMaisMovimento();
    }

    // Calcula o total de vendas no período
    private void calcularTotalVendas() {
        totalVendas = 0.0;
        for (Venda venda : vendas) {
            if (venda.getDataVenda().after(dataInicio) && venda.getDataVenda().before(dataFim)) {
                totalVendas += venda.getTotalVenda();
            }
        }
    }

    // Calcula o produto mais vendido no período
    public Produto calcularProdutoMaisVendido() {
        // Obtém o mapa de produtos com suas quantidades vendidas no período
        Map<Produto, Integer> produtoQuantidades = getProdutoIntegerMap();

        Produto maisVendido = null;
        int maiorQuantidade = 0;

        // Percorre o mapa para encontrar o produto com a maior quantidade vendida
        for (Map.Entry<Produto, Integer> entry : produtoQuantidades.entrySet()) {
            if (entry.getValue() > maiorQuantidade) {
                maiorQuantidade = entry.getValue();
                maisVendido = entry.getKey();
            }
        }

        return maisVendido;// Retorna o produto mais vendido
    }

    // Metodo auxiliar que cria um mapa de produtos com suas respectivas quantidades vendidas no período
    private Map<Produto, Integer> getProdutoIntegerMap() {
        Map<Produto, Integer> produtoQuantidades = new HashMap<>();

        for (Venda venda : vendas) {
            if (venda.getDataVenda().after(dataInicio) && venda.getDataVenda().before(dataFim)) {
                for (ItemVenda item : venda.getItens()) {
                    Produto produto = item.getProduto();
                    // Adiciona a quantidade ao mapa, somando com o valor atual (se existir)
                    produtoQuantidades.put(produto,
                            produtoQuantidades.getOrDefault(produto, 0) + item.getQuantidade());
                }
            }
        }
        return produtoQuantidades;
    }

    // Calcula os dias com maior número de vendas no período
    public List<Date> calcularDiasMaisMovimento() {
        Map<Date, Integer> vendasPorDia = new HashMap<>();

        for (Venda venda : vendas) {
            if (venda.getDataVenda().after(dataInicio) && venda.getDataVenda().before(dataFim)) {
                Date dia = venda.getDataVenda();
                vendasPorDia.put(dia, vendasPorDia.getOrDefault(dia, 0) + 1);
            }
        }

        List<Date> diasMaisMovimento = new ArrayList<>();
        int maiorNumeroVendas = 0;

        for (Map.Entry<Date, Integer> entry : vendasPorDia.entrySet()) {
            if (entry.getValue() > maiorNumeroVendas) {
                maiorNumeroVendas = entry.getValue();
                diasMaisMovimento.clear();
                diasMaisMovimento.add(entry.getKey());
            } else if (entry.getValue() == maiorNumeroVendas) {
                diasMaisMovimento.add(entry.getKey());
            }
        }

        return diasMaisMovimento;
    }

    // Getters para acessar os resultados do relatório
    public List<Venda> getVendas() {
        return vendas;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Produto getProdutoMaisVendido() {
        return produtoMaisVendido;
    }

    public List<Date> getDiasMaisMovimento() {
        return diasMaisMovimento;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    // Método para exibir o relatório completo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório de Vendas\n");
        sb.append("Período: ").append(dataInicio).append(" a ").append(dataFim).append("\n");
        sb.append("Total de Vendas: R$ ").append(totalVendas).append("\n");
        sb.append("Produto Mais Vendido: ").append(produtoMaisVendido != null
                ? produtoMaisVendido.getNome() : "Nenhum produto").append("\n");
        sb.append("Dias de Maior Movimento: ").append(diasMaisMovimento).append("\n");
        return sb.toString();
    }
}