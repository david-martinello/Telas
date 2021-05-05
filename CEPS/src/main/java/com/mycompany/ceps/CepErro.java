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
public class CepErro {
    
    String id_log;
    String mensagem_erro;

    public String getId_log() {
        return id_log;
    }

    public void setId_log(String id_log) {
        this.id_log = id_log;
    }

    

    public String getMensagem_erro() {
        return mensagem_erro;
    }

    public void setMensagem_erro(String mensagem_erro) {
        this.mensagem_erro = mensagem_erro;
    }

    @Override
    public String toString() {
        return "CepErro{" + "id_log=" + getId_log() + ", mensagem_erro=" + getMensagem_erro() + '}';
    }
    
    
    
}
