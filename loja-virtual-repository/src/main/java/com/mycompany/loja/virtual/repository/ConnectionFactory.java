/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author david.pereira
 */
public class ConnectionFactory {

    public Connection recuperarConeConnection() throws SQLException {
        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/Loja_virtual", "david", "64100122");

        

       
    }

}
