/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david.pereira
 */
public class TesteRemovendo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here3
        
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConeConnection();
        
//        PreparedStatement stm = connection.prepareStatement("Delete from produto where ID => 10");
//        stm.setInt(1, 2);
//        stm.execute();

        Statement stm = connection.createStatement();
        stm.execute("DELETE FROM produto WHERE id > 9");

        
        Integer linhasModificadas = stm.getUpdateCount();
        System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
    }
    
}
