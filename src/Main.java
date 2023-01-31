import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao programa de gerenciamento de produtos!");
        System.out.println("Defina o nome do produto a adicionar.");
        Scanner input = new Scanner(System.in);
        String nome = input.next();
        Produto produto1 = new Produto();
        produto1.setNome(nome);
        System.out.println("Digite o preço do produto no formato xx.yy. Exemplo: 12,75");
        double preco = input.nextDouble();
        produto1.setPreco(preco);
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Exibir a lista de produtos.");
            System.out.println("2. Adicionar outro produto.");
            System.out.println("3. Excluir um produto.");
            System.out.println("4. Encerrar o programa.");
            opcao = input.nextInt();

            if (opcao == 1) {
                for (Produto produto : produtos) {
                    System.out.println("nome: " + produto.nome);
                    System.out.println("preço: " + produto.preco);
                }
            } else if (opcao == 2) {
                System.out.println("Digite o nome do produto a adicionar.");
                String nomeProduto = input.next();
                Produto produto = new Produto();
                produto.setNome(nomeProduto);
                System.out.println("Digite o preço do produto no seguinte formato: 03.75");
                double precoProduto = input.nextDouble();
                produto.setPreco(precoProduto);
                produtos.add(produto);
            } else if (opcao == 3) {
                System.out.println("Digite o nome do produto a ser apagado da lista de produtos.");
                String nomeAApagar = input.next();
                for (int i = 0; i < produtos.size(); i++) {
                    Produto p = produtos.get(i);
                    if (p.nome.equalsIgnoreCase(nomeAApagar)) {
                        produtos.remove(i);
                        System.out.println("O produto foi removido!");
                        break;
                    } else {
                        int verificados = i + 1;
                        if (verificados == produtos.size()) {
                            System.out.println("Nenhum produto possui este nome! Nenhum item foi removido da lista.");
                        }
                    }
                }
            } else {
                System.out.println("O programa foi encerrado!");
            }
        } while (opcao < 4);
    }

}