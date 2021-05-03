
import com.mycompany.loja.virtual.dao.CategoriaDAO;
import com.mycompany.loja.virtual.modelo.Categoria;
import com.mycompany.loja.virtual.repository.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author david.pereira
 */
public class testaListagemCategoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        try (Connection connetion = new ConnectionFactory().recuperarConeConnection()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connetion);

            List<Categoria> listaDeCategorias = categoriaDAO.listar();
            
            listaDeCategorias.stream().forEach(ct -> System.out.println(ct.getNome()));
        }

    }

}
