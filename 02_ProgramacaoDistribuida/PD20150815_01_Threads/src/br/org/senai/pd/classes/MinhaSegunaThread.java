/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.senai.pd.classes;

/**
 *
 * @author walter
 */
public class MinhaSegunaThread implements Runnable {

    private int contagem = 100;
    public void run() {
        while (contagem > 0){
            System.out.println(contagem);
            contagem--;
        }
    }
    
}
