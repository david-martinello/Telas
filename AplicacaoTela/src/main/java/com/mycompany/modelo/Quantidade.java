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
public class Quantidade {

    private String quantidade;

    private List<Produto> produtos = new ArrayList<Produto>();

    public Quantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public String toString() {
        return this.quantidade.toString();
    }

}
