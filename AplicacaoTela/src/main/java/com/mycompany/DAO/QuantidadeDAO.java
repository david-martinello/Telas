/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.modelo.Produto;
import com.mycompany.modelo.Quantidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david.pereira
 */
public class QuantidadeDAO {

    private Connection connection;

    public QuantidadeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Quantidade> listar() {
        try {
            List<Quantidade> quantidades = new ArrayList<>();
            String sql = "select quantidade from QTD";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                try (ResultSet result = pstm.getResultSet()) {
                    while (result.next()) {
                        Quantidade quantidade = new Quantidade(result.getString(1));

                        quantidades.add(quantidade);
                    }
                }
            }
            return quantidades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Quantidade> listarComProdutos() {
        try {
            Quantidade ultima = null;
            List<Quantidade> quantidades = new ArrayList<>();

            String sql = "select C.id, C.nome, C.categoria, P.id, P.nome, P.descricao from quantidade inner join"
                    + " produto P on Q.qtd = P.quantidade";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                try (ResultSet result = pstm.getResultSet()) {
                    while (result.next()) {
                        if (ultima == null || ultima.getQuantidade().equals(result.getString(1)));
                        Quantidade quantidade = new Quantidade(result.getString(1));
                        ultima = quantidade;
                        quantidades.add(quantidade);
                    }
//                    Quantidade quantidade
//                            = new Quantidade(result.getInt(1));
//                    ultima.adicionar(produto);
                }
            }
            return quantidades;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    
//    public void salvar(Produto produto) {
//        try {
//
//            String sql = "insert into QTD (quantidade) VALUES (?)";
//            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//                pstm.setString(1, produto.getQuantidade());
//             
//
//                pstm.execute();
//
//                try (ResultSet rst = pstm.getGeneratedKeys()) {
//                    while (rst.next()) {
//                        produto.setId(rst.getInt(1));
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public void salvarComProdutos(Produto produto) {
//        
//        try {
//            String sql ="insert into produto (nome, descricao, Categoria_id, quantidade) values (?, ?, ?, ?)";
//            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
//               
//                pstm.setString(1, produto.getNome());
//                pstm.setString(2, produto.getDescricao());
//                pstm.setInt(3, produto.getCategoriaId());
//                pstm.setString(4, produto.getQuantidade());
//                
//                pstm.execute();
//                
//                try (ResultSet result = pstm.getResultSet()){
//                    while(result.next()){
//                        produto.setId(result.getInt(1));
//                    }
//                }
//            }
//            
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//        
    }
}
