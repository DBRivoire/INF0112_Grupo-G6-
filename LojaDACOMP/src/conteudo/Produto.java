package conteudo;

public class Produto {
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private int quantidadeEstoque;

    public Produto(String nome, double precoCusto, double precoVenda, int quantidadeEstoque) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (precoCusto <= 0 || precoVenda <= 0) {
            throw new IllegalArgumentException("Os preços devem ser maiores que zero.");
        }
        if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }

        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void atualizarPreco(double novoPreco) {
        if (novoPreco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        this.precoVenda = novoPreco;
    }


    public void atualizarEstoque(int quantidade) {
        if (this.quantidadeEstoque + quantidade < 0) {
            throw new IllegalArgumentException("Estoque insuficiente para essa operação.");
        }
        this.quantidadeEstoque += quantidade;
    }


    @Override
    public String toString() {
        return "Produto: " + nome +
                "\nPreço de Custo: R$ " + precoCusto +
                "\nPreço de Venda: R$ " + precoVenda +
                "\nQuantidade em Estoque: " + quantidadeEstoque;
    }


    // Getters e setters

     public String getNome() {
         return nome;
     }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    // Setter apenas para o nome, caso necessário
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }





}