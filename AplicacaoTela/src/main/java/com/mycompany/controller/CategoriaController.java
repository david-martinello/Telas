/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DAO.CategoriaDAO;
import com.mycompany.connection.ConnectionFactory;
import com.mycompany.modelo.Categoria;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author david.pereira
 */
public class CategoriaController {
    
    private CategoriaDAO categoriaDAO;
    
    
    public CategoriaController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.categoriaDAO = new CategoriaDAO(connection);
    }
    
    
    
    
    
    public List<Categoria> listar() {
		
		return this.categoriaDAO.listar();
	}
    
    
}
