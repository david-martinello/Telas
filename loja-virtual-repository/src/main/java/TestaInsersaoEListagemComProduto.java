
import com.mycompany.loja.virtual.dao.ProdutoDAO;
import com.mycompany.loja.virtual.modelo.Produto;
import com.mycompany.loja.virtual.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author david.pereira
 */
public class TestaInsersaoEListagemComProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        

        /*Criando um objeto comoda*/
        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        /*Aqui eu estou chando a conexão do banco pra implemenar a query*/
        try (Connection connection = new ConnectionFactory().recuperarConeConnection()) {
            
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);

            produtoDAO.salvar(comoda);
            
            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.stream().forEach(lp -> System.out.println(lp));

        }
        
    }
}
