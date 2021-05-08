/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david.pereira
 */
public class Categoria {
    private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

    public Categoria(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public String toString() {
		return this.nome;
	}
    
}
