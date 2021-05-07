/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.modelo.Categoria;
import com.mycompany.modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david.pereira
 */
public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() {
        try {
            List<Categoria> categorias = new ArrayList<>();

            String sql = "select id, nome from categoria";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                try (ResultSet rst = pstm.getResultSet()) {
                    while (rst.next()) {
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));

                        categorias.add(categoria);
                    }
                }
            }
            return categorias;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Categoria> listarComProdutos() throws SQLException {

        Categoria ultima = null;

        List<Categoria> categorias = new ArrayList<>();

        String sql = "select C.id, C.nome, P.id, P.nome, P.descricao from categoria C inner join "
                + "produto P on C.id = P.categoria_id";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    if (ultima == null || !ultima.getNome().equals(rst.getString(2))) {
                        Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                        ultima = categoria;
                        categorias.add(categoria);
                    }
                    Produto produto
                            = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
                    ultima.adicionar(produto);

                }
            }
        }
        return categorias;
    }

}
