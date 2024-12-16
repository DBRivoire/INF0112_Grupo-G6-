# INF0112_Grupo-G6-
# TCP - Etapa 2
## Gerenciador para a lojinha do DACOMP

**Autores:**
- Daniel Rocha
- Diogo Rivoire
- Patrick Alves

**Data:** 16 de dezembro de 2024

---

## Conteúdo
1. [Etapa 2 - Gerenciador de Lojinha DACOMP](#etapa-2---gerenciador-de-lojinha-dacomp)
   1. [Especificações](#especificações)
   2. [Mudanças em Relação à Etapa Anterior](#mudanças-em-relação-à-etapa-anterior)
   3. [Implementação](#implementação)
   4. [Teste](#teste)
   5. [Executável (aplicação, interface)](#executavel-aplicacao-interface)

---

## 1. Etapa 2 - Gerenciador de Lojinha DACOMP

### 1.1 Especificações
Um sistema que permite o gerenciamento de produtos em estoque, registrar vendas e acompanhar o histórico de transações. O software é focado no ponto de vista e necessidades do lojista.

---

### 1.2 Mudanças em Relação à Etapa Anterior
Nesta etapa, destacamos as mudanças realizadas em comparação com a Etapa 1:

- **Adaptação do escopo:** Foco no gerenciamento de estoque e histórico de vendas.
- **Melhor detalhamento dos requisitos:** Especificações mais claras e alinhadas ao escopo do projeto.

---

### 1.3 Implementação
O sistema foi desenvolvido utilizando **Java** e segue os princípios da **Programação Orientada a Objetos (POO)**. Ele simula a operação de uma cafeteria, permitindo o controle de estoque, vendas e relatórios.

#### Principais Classes

- **Classe `Cafeteria`**
   - Gerencia a quantidade de café no estoque.
   - Métodos: `verificarDisponibilidadeCafe`, `diminuirCafe`, `getQuantidadeCafeDisponivel`.

- **Classe `DescontoCaneca`**
   - Aplica descontos no preço de produtos.
   - Métodos: `calcularDesconto`.

- **Classe `Estoque`**
   - Gerencia o estoque de produtos.
   - Métodos: `adicionarProduto`, `removerProduto`, `consultarProduto`, `listarProdutos`.

- **Classe `RelatorioVendas`**
   - Gera relatórios com total de vendas e produtos mais vendidos.
   - Métodos: `gerarRelatorio`, `calcularTotalVendas`.

- **Classe `Produto`**
   - Representa os produtos vendidos.
   - Métodos: `atualizarPreco`, `atualizarEstoque`.

- **Classe `ItemVenda`**
   - Representa itens vendidos em uma venda.
   - Métodos: `calcularTotal`.

- **Classe `Venda`**
   - Representa uma venda realizada.
   - Métodos: `adicionarItem`, `calcularTotalVenda`.

- **Classe `ComboPromocional`**
   - Permite criar combos com desconto.
   - Métodos: `calcularPrecoCombo`.

---

### 1.4 Teste
Foram implementados testes unitários com **JUnit** seguindo a metodologia **Test-Driven Development (TDD)**.

#### Classes Testadas
- **Produto:** Criação e atualização de preço e estoque.
- **Estoque:** Adição, remoção e consulta de produtos.
- **Venda:** Validação da venda e atualização do estoque.
- **Cafeteria:** Controle do estoque de café.
- **DescontoCaneca e ComboPromocional:** Cálculo correto de descontos.

Essa abordagem garantiu a qualidade e confiabilidade do sistema.

---

### 1.5 Executável (aplicação, interface)
A interface foi desenvolvida usando **JavaFX** para permitir a interação do usuário com o sistema.

#### Funcionalidades:
- **Cadastro de Produtos:** Adicionar produtos ao estoque.
- **Exibição de Produtos:** Visualizar a lista de produtos.
- **Realização de Vendas:** Registrar vendas e atualizar o estoque.
- **Criação de Combos Promocionais:** Aplicar descontos em combos.
- **Aplicação de Descontos:** Gerenciar descontos específicos (como canecas).
- **Relatórios de Vendas:** Gerar relatórios de vendas.
- **Verificação de Estoque:** Consultar o estoque de café.

#### Manual Simplificado:
1. **Iniciar a aplicação:** Execute o arquivo JAR.
2. **Cadastro de Produtos:** Preencha os campos e clique em **Adicionar Produto**.
3. **Exibição de Produtos:** Clique em **Exibir Produtos**.
4. **Realização de Vendas:** Insira os detalhes da venda e clique em **Realizar Venda**.
5. **Criação de Combos:** Adicione produtos e o desconto desejado.
6. **Geração de Relatórios:** Escolha o período e clique em **Gerar Relatório**.

---

## Capturas de Tela

*(Insira aqui screenshots da interface da aplicação)*

---

## Requisitos
- **Java 11 ou superior**
- **JUnit** (para testes)
- **JavaFX** (para interface gráfica)

---

## Como Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/tcp-lojinha-dacomp.git
   ```
2. Compile o projeto com seu IDE ou terminal:
   ```bash
   javac -cp . *.java
   ```
3. Execute o arquivo JAR gerado.

---

## Contribuições
Pull requests são bem-vindos. Para grandes mudanças, abra uma *issue* primeiro para discutir o que você gostaria de mudar.

---

## Licença
Este projeto está licenciado sob a [MIT License](LICENSE).


