/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.dao;

import com.mycompany.loja.virtual.modelo.Produto;
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
public class ProdutoDAO {

    public Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;

    }

    public void salvar(Produto produto) throws SQLException{
        
        
        String sql = "insert into produto (NOME, DESCRICAO) VALUES (?, ?)";

        /*Aqui estou utilizando a interface  PreparedStatement  passando os parametros para 
            inserção no banco*/
        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            /*Aqui eu estou chamando os metodos get e set para a inserção dos dados nos
                deidos locais*/
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));

                }
            }

        }
    }
    
    public List<Produto> listar() throws SQLException{
        List<Produto> produtos = new ArrayList<Produto>();
        
        String sql = "select id, nome, descricao from produto";
        
        try(PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();
            
            try (ResultSet rst = pstm.getResultSet()){
                while (rst.next()){
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
                    
                    
                    produtos.add(produto);
                }
            }
            
        }
        return produtos;
    }
}
