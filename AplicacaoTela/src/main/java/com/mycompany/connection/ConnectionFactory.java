/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author david.pereira
 */
public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/Loja_virtual");
        comboPooledDataSource.setUser("david");
        comboPooledDataSource.setPassword("64100122");

        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
