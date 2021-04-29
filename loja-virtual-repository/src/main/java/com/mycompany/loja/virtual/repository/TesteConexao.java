/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import java.sql.Connection;

import java.sql.SQLException;

/**
 *
 * @author david.pereira
 */
public class TesteConexao {
  
    public static void main(String[] args)throws SQLException{
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConeConnection();
    }
    
        

}
