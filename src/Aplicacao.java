import java.util.Scanner;

/**
 * Classe principal do programa para ler inputs do usuario
 * @author JPPauletti
 */
public class Aplicacao {

    static Scanner s = new Scanner(System.in);

    /**
     * Vetor de pizzas
     */
    private static PedidoPizza[] pizza = new PedidoPizza[10];

    /**
     * Conta o numero de pizzas existentes no vetor
     */
    private static int contador = 0;

    /**
     * Adiciona uma pizza ao vetor de pizzas, se o vetor estiver cheio, lança uma exceção.
     */
    public static void adicionarPizza() {
        try {
            pizza[contador++] = new PedidoPizza();
            System.out.println("\nPizza adicionada com sucesso");
        } catch (Exception e) {
            System.out.println("\nErro ao adicionar pizza");
        }
    }

    /**
     * Adiciona um numero de ingredientes a pizza escolhida, se o numero de ingredientes for menor que 0 ou maior que 8, lança uma exceção.
     */
    private static void adicionarIngrediente() {

        imprimirNotaFiscal();

        System.out.print("\nDigite o número da pizza: ");
        int i = s.nextInt() - 1;

        if (pizza[i] == null) {
            System.out.println("\nPizza não encontrada");
            return;
        }

        try {
            System.out.print("\nDigite a quantidade de ingredientes a ser adicionado: ");
            pizza[i].adicionarIngrediente(s.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retira um numero de ingredientes da pizza escolhida, se o numero de ingredientes for menor que 0 ou maior que o numero de ingredientes da pizza, lança uma exceção.
     */
    private static void retirarIngrediente() {

        imprimirNotaFiscal();

        System.out.print("\nDigite o numero da pizza: ");
        int i = s.nextInt() - 1;

        if (pizza[i] == null) {
            System.out.println("\nPizza não encontrada");
            return;
        }

        try {
            System.out.print("\nDigite a quantidade de ingredientes a ser retirado: ");
            pizza[i].retirarIngrediente(s.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Imprime a nota fiscal com o numero da pizza, o numero de ingredientes e o preco da pizza.
     */
    private static void imprimirNotaFiscal() {
        int i = 1;
        for (PedidoPizza p1 : pizza) {
            if (p1 != null) {
                System.out.println("Pizza: " + i++ + " com " + p1.getIngrediente() + " ingredientes - R$ " + p1.getPreco());
            }
        }
    }

    public static void main(String[] args) {

        int opcao = 0;

        System.out.println("\nBem vindo a Xulambs Pizza!\n");

        do {
            System.out.println("\nMenu de opções\n");
            System.out.println("1 - Adicionar Pizza");
            System.out.println("2 - Adicionar Ingredientes");
            System.out.println("3 - Retirar Ingredientes");
            System.out.println("4 - Emição de nota fiscal");
            System.out.println("5 - Sair");
            System.out.print("\nDigite a opcao desejada: ");

            opcao = s.nextInt();

            switch (opcao) { // switch case para escolher a opção desejada

                // 1 - uma pizza é adicionada
                case 1:
                    adicionarPizza();
                    break;

                // 2 -  os ingredientes serão adicionados
                case 2: 
                    adicionarIngrediente();
                    break;
                
                // 3 - os ingredientes serão retirados
                case 3: 
                    retirarIngrediente();
                    break;

                // 4 - a nota fiscal será impressa
                case 4: 
                    imprimirNotaFiscal();
                    break;

                // 5 - o programa será encerrado
                case 5: 
                    System.out.println("\n\nObrigado por utilizar o sistema Xulambs Pizza!\n");
                    break;
            }
        } while (opcao != 5);
    }
}
