/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

/**
 *
 * @author david.pereira
 */
public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer categoriaId;
    private String quantidade;

    public Produto(String nome, String descricao, String quantidade) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Produto(Integer id, String nome, String descricao, String quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;

    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("O produto é: %d, %s, %s, %s", this.id, this.nome, this.descricao, this.quantidade);
    }

}
