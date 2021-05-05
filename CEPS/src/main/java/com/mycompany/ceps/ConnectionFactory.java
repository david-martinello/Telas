package com.mycompany.ceps;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david.pereira
 */
public class ConnectionFactory {
    
    public DataSource dataSource;
    
    public ConnectionFactory(){
        
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/CEPS");
        comboPooledDataSource.setUser("david");
        comboPooledDataSource.setPassword("64100122");
        
        comboPooledDataSource.setMaxPoolSize(100);
        this.dataSource = comboPooledDataSource;
        
    }
    public Connection recuperaConexao() throws SQLException{
        return this.dataSource.getConnection();
           
    }
    
}
