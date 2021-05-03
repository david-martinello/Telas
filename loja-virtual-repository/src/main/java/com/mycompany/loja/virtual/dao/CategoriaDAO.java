package com.mycompany.loja.virtual.dao;

import com.mycompany.loja.virtual.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() throws SQLException{
        List<Categoria> categorias = new ArrayList<>();

        String sql = "select id, nome from categoria";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
           pstm.execute();
           
           try(ResultSet rst = pstm.getResultSet()){
               while(rst.next()){
                   Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
                   
                   categorias.add(categoria);
               }
           }
        }
        return categorias;
    }

}
