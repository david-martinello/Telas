package com.mycompany.ceps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<Cep> buscarDados() throws SQLException {
        List<Cep> cepErros = new ArrayList<Cep>();

        String sql2 = "SELECT cep FROM Cep ";

        try (PreparedStatement pstm2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS)) {
            pstm2.executeUpdate();

            try (ResultSet resultSet = pstm2.getResultSet()) {
                while (resultSet.next()) {
                    Cep cep1 = new Cep(resultSet.getString(1));
                    cepErros.add(1, cep1);

                }
            }
//

        }
        return cepErros;
        //    public List<Cep> buscaDados() throws SQLException {
        //        List<Cep> ceps = new ArrayList<Cep>();
        //
        //        String sql2 = "SELECT cep FROM Cep ";
        //
        //        try (PreparedStatement pstm2 = connection.prepareStatement(sql2)) {
        //            pstm2.executeUpdate();
        //
        //            try (ResultSet rstBuscaDados = pstm2.getResultSet()) {
        //                while (rstBuscaDados.next()) {
        //                    Cep cep = new Cep(rstBuscaDados.getString(1));
        //                    ceps.add(1, cep);
        //                }
        //            }
        //        }
        //        return ceps;
    }
        /**
         *
         * @throws SQLException }
         */
    public void adicionarErro(CepErro erro) throws SQLException {

        String sql = ("insert into Erros (id_log, mensagem_erro) values (?,?)");
        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, erro.getId_log());
            pstm.setString(2, erro.getMensagem_erro());

            if (erro.equals(erro)) {
                throw new RuntimeException("Error 404");
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("Rollback acionado Para RuntimeException");

            System.out.println("");
            connection.rollback();

        } catch (SQLIntegrityConstraintViolationException ex) {
            ex.printStackTrace();
            System.err.println("Rollback acionado para SQLIntegrityConstraintViolationException");;
            connection.rollback();

        }
    }
//    public void buscar(Cep cepDitadao) throws SQLException {
//
//        try (PreparedStatement stm = connection.prepareStatement("SELECT Cep, localidade, uf, codigo_ibge, bairro, logradouro, complemento Ceps");) {
//            stm.execute();
//            ResultSet resultSet = stm.getResultSet();
//
//            while (resultSet.next()) {
//                String cep = resultSet.getString("Cep");
//                System.out.println(cep);
//                String localidade = resultSet.getString("localidade");
//                System.out.println(localidade);
//                String uf = resultSet.getString("uf");
//                System.out.println(uf);
//                String codigo_ibge = resultSet.getString("codigo_ibge");
//                System.out.println(codigo_ibge);
//                String bairro = resultSet.getString("bairro");
//                System.out.println(bairro);
//                String logradouro = resultSet.getString("logradouro");
//                System.out.println(logradouro);
//                String complemento = resultSet.getString("complemento");
//                System.out.println(complemento);
//
//            }
//        }
//
//  }
}

