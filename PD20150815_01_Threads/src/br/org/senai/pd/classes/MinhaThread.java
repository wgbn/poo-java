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
public class MinhaThread extends Thread {
    @Override
    public void run(){
        while(true){
            System.out.println("Minha thread");
        }
    }
}
