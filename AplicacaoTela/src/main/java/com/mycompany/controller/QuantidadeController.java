/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.QuantidadeDAO;
import com.mycompany.connection.ConnectionFactory;
import com.mycompany.modelo.Produto;
import com.mycompany.modelo.Quantidade;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author david.pereira
 */
public class QuantidadeController {
    private QuantidadeDAO quantidadeDAO;
    
    public QuantidadeController(){
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.quantidadeDAO = new QuantidadeDAO(connection);
    }
    
    public List<Quantidade> listar(){
        return this.quantidadeDAO.listar();
    }
    
    public void salvarComProdutos(Produto produto){
        this.quantidadeDAO.salvarComProdutos(produto);
    }
    public void salvar(Produto produto){
        this.quantidadeDAO.salvar(produto);
    }
    
}
