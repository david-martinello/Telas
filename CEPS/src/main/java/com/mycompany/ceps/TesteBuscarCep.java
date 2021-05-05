/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ceps;

import java.util.Scanner;

/**
 *
 * @author david.pereira
 */
public class TesteBuscarCep {

    public static void main(String[] args) {
        System.out.println("Digite um cep");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        CepControl cepControl = new CepControl();
        cepControl.buscarCep(s);

        System.out.println(cepControl);

    }
}
