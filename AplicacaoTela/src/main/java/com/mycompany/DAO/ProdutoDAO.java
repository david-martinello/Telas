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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david.pereira
 */
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

//    public void salvar(Produto produto) {
//        try {
//
//            String sql = "insert into produto (NOME, DESCRICAO) VALUES (?, ?)";
//            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//                pstm.setString(1, produto.getNome());
//                pstm.setString(2, produto.getDescricao());
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

    public void salvarComCategoria(Produto produto) {
        try {

            String sql = "insert into produto (NOME, DESCRICAO, quantidade, Categoria_id ) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, produto.getNome());
                pstm.setString(2, produto.getDescricao());
                pstm.setString(3, produto.getQuantidade());
                pstm.setInt(4, produto.getCategoriaId());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        produto.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }//"INSERT INTO produto (nome, descricao, categoria_id) VALUES (?, ?, ?)"
    

    public List<Produto> listar() {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            String sql = "SELECT id, nome, descricao, quantidade FROM produto";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                trasformarResultSetEmProduto(produtos, pstm);
            }
            return produtos;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public List<Produto> buscar(Categoria ct) {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            String sql = "SELECT id, nome, descricao, quantidade FROM produto WHERE Categoria_id = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, ct.getId());
                pstm.execute();

                trasformarResultSetEmProduto(produtos, pstm);
            }
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletar(Integer id) {
        try {
            try (PreparedStatement stm = connection.prepareStatement("DELETE FROM produto WHERE id = ?")) {
                stm.setInt(1, id);
                stm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void alterar(String nome, String descricao, String quantidade, Integer id) {
        try {
            try (PreparedStatement stm = connection
                    .prepareStatement("update produto p set p.nome = ?, p.descricao = ?, p.quantidade=? WHERE id = ?")) {
                stm.setString(1, nome);
                stm.setString(2, descricao);
                stm.setString(3, quantidade);
                stm.setInt(4, id);
                
                stm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void trasformarResultSetEmProduto(List<Produto> produtos, PreparedStatement pstm) {
        try {

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4));

                    produtos.add(produto);
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
//