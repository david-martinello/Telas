/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import java.sql.SQLException;

/**
 *
 * @author david.pereira
 */
public class TestaPoolConexoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        for (int i = 0; i < 20; i++) {
            connectionFactory.recuperarConeConnection();
            System.out.println("Conexão de numero: " + i);
            
        }
       
    }
    
}
