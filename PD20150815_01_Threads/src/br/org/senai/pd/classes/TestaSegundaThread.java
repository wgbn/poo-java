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
public class TestaSegundaThread {
    public static void main(String[] args) {
        MinhaSegunaThread st = new MinhaSegunaThread();
        Thread minhaThread = new Thread(st);
        minhaThread.start();
        while (minhaThread.isAlive())
        System.out.println("Fazendo qualquer coisa!");
    }
}
