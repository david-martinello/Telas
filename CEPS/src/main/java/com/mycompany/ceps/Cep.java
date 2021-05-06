/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ceps;

/**
 *
 * @author david.pereira
 */
public class Cep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;
    private String gia;

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public Cep setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Cep setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public Cep setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Cep setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public Cep setLocalidade(String localidade) {
        this.localidade = localidade;
        return this;
    }

    public Cep setUf(String uf) {
        this.uf = uf;
        return this;
    }

    public Cep setUnidade(String unidade) {
        this.unidade = unidade;
        return this;
    }

    public Cep(String cep) {
        this.cep = cep;
    }

    public Cep setIbge(String ibge) {
        this.ibge = ibge;
        return this;
    }

    public Cep setGia(String gia) {
        this.gia = gia;
        return this;
    }

   
    @Override
    public String toString() {
        return "Cep{" + "cep=" + getCep() + ", logradouro=" + getLogradouro() + ", complemento=" 
                + getComplemento() + ", bairro=" + getBairro() + ", localidade=" + getLocalidade() + ", uf=" + getUf() 
                + ", unidade=" 
                + getUnidade() + ", ibge=" + getIbge() + ", gia=" + getGia() + '}';
    }
}

