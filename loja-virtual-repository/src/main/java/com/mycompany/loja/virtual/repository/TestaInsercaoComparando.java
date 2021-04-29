/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david.pereira
 */
public class TestaInsercaoComparando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        String nome = "J5";
        String descriccao = "Metal";

        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.recuperarConeConnection();

     

        PreparedStatement stm = 
                connection.prepareStatement
        ("insert into produto (nome, descricao) VALUES (?, ?)"
                ,Statement.RETURN_GENERATED_KEYS);
        
        stm.setString(1, nome);
        stm.setString(2, descriccao);
        
        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println(" O id criado foi " + id);
        }
    }

}
