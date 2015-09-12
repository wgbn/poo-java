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
public class Principal {
    public static void main(String[] args) {
        MinhaThread t1 = new MinhaThread();
        Thread t2 = new Thread(new MinhaSegunaThread());
        
        t1.start();
        t2.start();
        
        while(true)
            System.out.println("Thread principal");
    }
}
