package com.mycompany.ceps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david.pereira
 */
public class CEPDAO {

    public Connection connection;

    public CEPDAO(Connection connection) {
        this.connection = connection;

    }

    public void salvar(Cep cepDigitado) throws SQLException {

        String sql = "insert into Ceps (Cep, localidade, uf, codigo_ibge, bairro, logradouro, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        /*Aqui estou utilizando a interface  PreparedStatement  passando os parametros para 
            inserção no banco*/
        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            /*Aqui eu estou chamando os metodos get e set para a inserção dos dados nos
                deidos locais*/
            pstm.setString(1, cepDigitado.getCep());
            pstm.setString(2, cepDigitado.getLocalidade());
            pstm.setString(3, cepDigitado.getUf());
            pstm.setString(4, cepDigitado.getIbge());
            pstm.setString(5, cepDigitado.getBairro());
            pstm.setString(6, cepDigitado.getLogradouro());
            pstm.setString(7, cepDigitado.getComplemento());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    cepDigitado.setCep(rst.getString(1));

                }
            }

        }

    }
}
