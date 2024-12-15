// Classe DescontoCaneca


    package service;

    public class DescontoCaneca {
        private double desconto; // Desconto aplicado (em %)

        // Construtor
        public DescontoCaneca(double desconto) {
            this.desconto = desconto;
        }

        // Método para calcular o preço com desconto
        public double calcularDesconto(double precoOriginal) {
            return precoOriginal - (precoOriginal * (desconto / 100));
        }

        public double getDesconto() {
            return desconto;
        }

        public void setDesconto(double desconto) {
            this.desconto = desconto;
        }
    }
