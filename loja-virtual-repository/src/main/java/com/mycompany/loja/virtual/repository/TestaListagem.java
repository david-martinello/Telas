/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author david.pereira
 */
public class TestaListagem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConeConnection();

        PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM produto");
        stm.execute();

        ResultSet rst = stm.getResultSet();

        while (rst.next()) {
            Integer id = rst.getInt("iD");
            System.out.println(id);
            String nome = rst.getString("NOME");
            System.out.println(nome);
            String descricao = rst.getString("DESCRICAO");
            System.out.println(descricao);
        }

        connection.close();

    }

}
