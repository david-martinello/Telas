/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.ProdutoDAO;
import com.mycompany.connection.ConnectionFactory;
import com.mycompany.modelo.Produto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david.pereira
 */
public class ProdutoController {
    
    private ProdutoDAO produtoDAO;
    
    
    public ProdutoController(){
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.produtoDAO = new ProdutoDAO(connection);
    }
    
    
    
    public void deletar(Integer id) {
        this.produtoDAO.deletar(id);
		System.out.println("Deletando produto");
	}

	public void salvar(Produto produto) {
            this.produtoDAO.salvarComCategoria(produto);
            
            
		System.out.println("Salvando produto");
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}

	public void alterar(String nome, String descricao, Integer id, String quantidade) {
            this.produtoDAO.alterar(nome, descricao, id, quantidade);
            
		System.out.println("Alterando produto");
	}
        public void salvarCategoria(Produto produto){
            this.produtoDAO.salvarComCategoria(produto);
        }
        
}
    

