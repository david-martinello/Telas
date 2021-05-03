/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;



/**
 *
 * @author david.pereira
 */
public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() {

        /*Aqui estamos configurando o Pool de conexões */
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        /*Configurando a url de conexão*/
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/Loja_virtual");

        /*Configurando o usuario do banco*/
        comboPooledDataSource.setUser("david");

        /*Configurando a senha do Banco*/
        comboPooledDataSource.setPassword("64100122");
        
        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;

    }

    public Connection recuperarConeConnection() throws SQLException {
        return this.dataSource.getConnection();

    }

}
