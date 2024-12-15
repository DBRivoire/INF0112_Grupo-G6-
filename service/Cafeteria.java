// Classe cafeteria

package service;

public class Cafeteria {
    private int quantidadeCafeDisponivel; // Quantidade de café em estoque (em unidades)

    // Construtor
    public Cafeteria(int quantidadeInicial) {
        this.quantidadeCafeDisponivel = quantidadeInicial;
    }

    // Verifica se há café suficiente disponível
    public boolean verificarDisponibilidadeCafe(int quantidade) {
        return quantidade <= quantidadeCafeDisponivel;
    }

    // Diminui a quantidade de café no estoque
    public void diminuirCafe(int quantidade) {
        if (verificarDisponibilidadeCafe(quantidade)) {
            quantidadeCafeDisponivel -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente de café em estoque!");
        }
    }

    // Getters e setters
    public int getQuantidadeCafeDisponivel() {
        return quantidadeCafeDisponivel;
    }

    public void setQuantidadeCafeDisponivel(int quantidadeCafeDisponivel) {
        this.quantidadeCafeDisponivel = quantidadeCafeDisponivel;
    }

    @Override
    public String toString() {
        return "Cafeteria{" +
                "quantidadeCafeDisponivel=" + quantidadeCafeDisponivel +
                '}';
    }
}