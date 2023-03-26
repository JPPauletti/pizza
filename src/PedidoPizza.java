/**
 * Classe que representa um pedido de pizza
 * @author JPPauletti
 */
public class PedidoPizza {

    /**  
     * Numero de ingredientes da pizza
     */
    private int ingrediente;

    /**
     * Construtor da classe PedidoPizza, inicializa o numero de ingredientes com 0.
     */
    public PedidoPizza() {
        this.ingrediente = 0;
    }

    /**
     * Adiciona um numero de ingredientes a pizza, se o numero de ingredientes for menor que 0 ou maior que 8, lança uma exceção.
     * @param adicional numero de ingredientes a ser adicionado
     * @throws Exception caso o numero de ingredientes seja menor que 0 ou maior que 8
     */
    public void adicionarIngrediente(int adicional) throws Exception {
        if (adicional <= 0 || ingrediente + adicional > 8)
            throw new Exception("Numero de adicionais invalido");
        ingrediente += adicional;   
    }

    /**
     * Retira um numero de ingredientes da pizza, se o numero de ingredientes for menor que 0 ou maior que o numero de ingredientes da pizza, lança uma exceção.
     * @param adicional numero de ingredientes a ser retirado
     * @throws Exception caso o numero de ingredientes seja menor que 0 ou maior que o numero de ingredientes da pizza
     */
    public void retirarIngrediente(int adicional) throws Exception {
        if (adicional <= 0 || ingrediente - adicional < 0)
            throw new Exception("Numero de retiradas invalido");
        ingrediente -= adicional;
    }

    /**
     * Retorna o preco da pizza, sendo o preco base de 25 reais mais 4 reais por ingrediente.
     * @return preco da pizza
     */
    public int getPreco() {
        return 25 + ingrediente * 4;
    }

    /**
     * @return numero de ingredientes da pizza
     */
    public int getIngrediente() {
        return ingrediente;
    }

}
