
package conteudo;

    public class ItemVenda {
        private Produto produto;
        private int quantidade; // quantidade de venda do produto


        public ItemVenda(Produto produto, int quantidade) {
            if (produto == null) {
                throw new NullPointerException("Produto não pode ser nulo");
            }
            if (quantidade <= 0) {
                throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
            }

            this.produto = produto;
            this.quantidade = quantidade;
        }


        //Métodos

    // Calcula o total do item (preço de venda * quantidade)
    public double calcularTotal() {
        return produto.getPrecoVenda() * quantidade;
    }

        // Getters e Setters
        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            if (produto == null) {
                throw new NullPointerException("Produto não pode ser nulo");
            }
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            if (quantidade <= 0) {
                throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
            }
            this.quantidade = quantidade;
        }


        @Override
        public String toString() {
            return "ItemVenda{" +
                    "produto=" + produto.getNome() +
                    ", quantidade=" + quantidade +
                    ", total=R$ " + calcularTotal() +
                    '}';
        }

    }
