/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loja.virtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david.pereira
 */
public class TestaInsercaoComparando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        //Aqui estamos fazendo a conexão com o banco 
        ConnectionFactory factory = new ConnectionFactory();
        
        /*tyr tem um tratamento para ele ao fim da execução fechar a conexão automaticamente*/
        try (Connection connection = factory.recuperarConeConnection()) {

            /*Aqui tou fazendo com que se algum produto estiver com erro de inserção
        esse auto commit não vai adicionar nenhum dos produtos passados
             */
            connection.setAutoCommit(false);

            /*Estou fazendo esse try catch para que se caso tenha aulguma ecessão o
        ROLLBACK disfaz todas as alterações e traz uma mensagem avissando 
        E alem disso esse try está com recursos o chamado try-with-resources
        que me permite usar esses recursos pois dentro de PreparedStatement ele extend de 
        Statement que tem um metodo fechar coneção  isso permite que não precisa declarar
        o fechamento da conexão em caso de esquecimento*/
            try (PreparedStatement stm //Aqui estou fazendo a inserção dos dados no banco 
                    = connection.prepareStatement("insert into produto (nome, descricao) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);) {

                //Aqui estou inserindo os dados 
                adicionarVariavel("Ipad", "128GB", stm);
                adicionarVariavel("Boneco", "Maldito", stm);

                /*Aqui estou passando para o connection fazer o commit no banco caso não
        possua erro de inserção de produtos
                 */
                connection.commit();

                /*Aqui estou fechando a conexão*/
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK ACIONADO");
                connection.rollback();
            }
        }
    }

    /*Aqui eu crie um metodo adicionarVariavel onde eu falo  que  ? seja nome e 
    ?seja a descricao*/
    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {

        /*Aqui estou setando a String inserida la em adicionarVariavel e o stm setando os valores */
        stm.setString(1, nome);
        stm.setString(2, descricao);

        /*Aqui eu posso fazer esseções nesse exemplo abaixo tou dizendo que se o nome inserido
        for igual a boneco  ele não deixa eu inserir esse produto  e ele esta fazendo um ganxo
        com o connection.setAutoCommit(false) que se caso tiver mais de um produto inserido ele não deixa adicionar nenhum*/
        if (nome.equals("")) {
            throw new RuntimeException("Não foi possivel adicionar este item");
        }

        /*Aqui é onde será executado o PreparedStatement*/
        stm.execute();

        /*Aqui estou criando uma variavel  rst  e ele irá puxar ageração de chaves, como ja falado la 
        em cima esse tyr tem um tratamento para ele ao fim da execução fechar a conexão automaticamente
         */
        try (ResultSet rst = stm.getGeneratedKeys()) {

            /*Esse while esta fazendo oadicionamento do produto e inserindo na coluna e linha correta */
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println(" O id criado foi " + id);
            }
        }
    }

}
