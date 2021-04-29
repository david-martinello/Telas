/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david.pereira
 */
public class TestaInsercao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        ConnectionFactory factory = new ConnectionFactory();
        
        Connection connection = factory.recuperarConeConnection();
        
      Statement  stm = connection.createStatement();
      
      stm.execute("insert into produto (nome, descricao) VALUES ('Para remover', 'ruim')",
              Statement.RETURN_GENERATED_KEYS);
      
        ResultSet rst = stm.getGeneratedKeys();
        while(rst.next()){
            Integer id = rst.getInt(1);
            System.out.println(" O id criado foi "+ id);
        }
            
      
        
    }
    
}
