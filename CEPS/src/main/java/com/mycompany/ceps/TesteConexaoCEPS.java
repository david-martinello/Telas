/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ceps;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author david.pereira
 */
public class TesteConexaoCEPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();
        
    }
    
}
