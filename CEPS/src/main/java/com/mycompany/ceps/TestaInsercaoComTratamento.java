package com.mycompany.ceps;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Scanner;

public class TestaInsercaoComTratamento {

    public static void main(String[] args) throws SQLException, NullPointerException{

       ConnectionFactory factory = new ConnectionFactory();
       Connection connection = factory.recuperaConexao();

       Scanner scan = new Scanner(System.in);
       System.out.println("Insira o CEP");
       String x = scan.nextLine();

       Cep cep = new Cep(x);
       CepControl cepControl = new CepControl();
       
       cep = CepControl.buscarCep(x);
       System.out.println(cep.getIbge());
       
       CEPDAO cepdao = new CEPDAO(connection);

       cepdao.salvar(cep);
       
       CepErro cepErro = new CepErro();
       cepdao.adicionarErro(cepErro);

       System.out.println("Guardando informações...");
       connection.close();
       
       try{
           cepdao.salvar(cep);
           cepdao.buscarDados();
           List<Cep>listagemCep = cepdao.buscarDados();
           listagemCep.stream().forEach(listaCep -> System.out.println(listaCep));
           
        }catch (SQLException sqlex){
           sqlex.printStackTrace();
           System.out.println("erro");
           
        }
       connection.close();

    }
}
