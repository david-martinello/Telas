
package com.mycompany.ceps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david.pereira
 */
public class ErrosDAO {

    private static final String url = "jdbc:mysql://localhost:3306/CEPS";
    private static final String user = "david";
    private static final String pass = "64100122";
    static Connection con;

    public void buscar(Cep cep) throws SQLException {

        String sql = "insert into Erros (id_log, mensagem_erro) values (id_log = id_log +1, 'Cep invalido') ";
        con = DriverManager.getConnection(url, user, pass);
        Statement stm = con.createStatement();

        stm.execute(sql);
    }

    public void verificar(Cep cep) throws SQLException, IOException {
        String sql1 = "select * from Ceps where Cep = '" + cep.getCep() + "'";
        Statement stm1 = con.createStatement();
        con = DriverManager.getConnection(url, user, pass);
        ResultSet resultSet = stm1.executeQuery(sql1);
        if (resultSet.next()) {
            System.out.println("Cep existente, atualizando cep");
            duplicar(cep);

        } else {
            System.out.println("Efetuando cadastro");

        }
        con.close();
    }

    public void duplicar(Cep cep) throws SQLException {
        con = DriverManager.getConnection(url, user, pass);
        Statement stm = con.createStatement();

        String sql = ("INSERT INTO Ceps (Cep,  localidade, uf, codigo_ibge, bairro, logradouro, complemento ) values ('" + cep.getCep() + "', "
                + "'" + cep.getLocalidade() + "', '" + cep.getUf() + "',"
                + "'" + cep.getIbge() + "', '" + cep.getBairro() + "', '" + cep.getLogradouro() + "',"
                + " '" + cep.getComplemento() + "') ON DUPLICATE KEY UPDATE Cep = '" + cep.getCep() + "',"
                + "localidade ='" + cep.getLocalidade() + "', uf ='" + cep.getUf() + "', codigo_ibge ='" + cep.getIbge() + "'"
                + ", bairro = '" + cep.getBairro() + "',"
                + "logradouro ='" + cep.getLogradouro() + "', complemento ='" + cep.getComplemento() + "'");

        stm.execute(sql);
        System.out.println("Cep atualizado.");

    }

}
