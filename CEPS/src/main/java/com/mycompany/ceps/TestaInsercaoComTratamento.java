package com.mycompany.ceps;

import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Scanner;

public class TestaInsercaoComTratamento {

    public static void main(String[] args) throws SQLException, NullPointerException, IOException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperaConexao();


        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o CEP");
        String x = scan.nextLine();

        while (x.length() != 8) {
            System.out.println("Tente novamente ");
            x = scan.nextLine();

        }
        Cep cep = new Cep(x);
        CepControl cepControl = new CepControl();

        cep = CepControl.buscarCep(x);
        System.out.println(cep.getIbge());

        CEPDAO cepdao = new CEPDAO(connection);
        ErrosDAO edao = new ErrosDAO();


        edao.buscar(cep);
        edao.verificar(cep);
        edao.duplicar(cep);

        System.out.println("Guardando informações...");

        connection.close();

    }
}
