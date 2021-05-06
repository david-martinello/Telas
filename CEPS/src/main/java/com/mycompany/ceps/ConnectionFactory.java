package com.mycompany.ceps;


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
