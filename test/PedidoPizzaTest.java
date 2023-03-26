import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/**
 * Testes da classe PedidoPizza
 * @author JPPauletti
 */
public class PedidoPizzaTest {

    private PedidoPizza pizza;

/* Mensagem ao professor Caram: Não consegui utilizar o BeforeEach para inicializar a "pizza = new PedidoPizza", pois dava o erro de 'java.lang.NullPointerException' então, inicializei ela em cada teste individual. */
    
    /**
     * Testa o metodo adicionarIngrediente, adicionando 8 ingredientes separados e verificando se o numero de ingredientes é 8.
     */
    @Test
    public void tentaAdicionarIngrediente() throws Exception {
        pizza = new PedidoPizza(); 
        pizza.adicionarIngrediente(2);
        pizza.adicionarIngrediente(6);
        assertEquals(8, pizza.getIngrediente());
    }

    /**
     * Testa o metodo adicionarIngrediente, adicionando incorretamente 9 ingredientes e verificando se a exceção é lançada.
     */
    @Test
    public void tentaAdicionarIngredienteInvalido() throws Exception {
        pizza = new PedidoPizza();
        pizza.adicionarIngrediente(2);
        pizza.adicionarIngrediente(6);
        try {
            pizza.adicionarIngrediente(1);
        } catch (Exception e) {
            assertEquals("Numero de adicionais invalido", e.getMessage());
        }
    }

    /**
     * Testa o metodo retirarIngrediente, adicionando 8 ingredientes e retirando 5, verificando se o numero de ingredientes é 3.
     */
    @Test
    public void tentaRetirarIngrediente() throws Exception {
        pizza = new PedidoPizza();
        pizza.adicionarIngrediente(2);
        pizza.adicionarIngrediente(6);
        pizza.retirarIngrediente(2);
        pizza.retirarIngrediente(3);
        assertEquals(3, pizza.getIngrediente());
    }

    /**
     * Testa o metodo retirarIngrediente, adicionando 8 ingredientes e retirando incorretamente 10, verificando se a exceção é lançada.
     */
    @Test
    public void tentaRetirarIngredienteInvalido() throws Exception {
        pizza = new PedidoPizza();
        pizza.adicionarIngrediente(2);
        pizza.adicionarIngrediente(6);
        try {
            pizza.retirarIngrediente(10);
        } catch (Exception e) {
            assertEquals("Numero de retiradas invalido", e.getMessage());
        }
    }
    
    /**
     * Testa o metodo getPreco, adicionando 6 ingredientes e verificando se o preço final é 49.
     */
    @Test
    public void getPreco() throws Exception {
        pizza = new PedidoPizza();
        pizza.adicionarIngrediente(2);
        pizza.adicionarIngrediente(4);
        assertEquals(49, pizza.getPreco());
    }  
}
