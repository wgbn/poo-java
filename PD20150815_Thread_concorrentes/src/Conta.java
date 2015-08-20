/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author walter
 */
public class Conta {
    double saldo = 0;
    
    public void depositar(double _valor){
        saldo += _valor;
    }
    
    public synchronized void sacar(double _valor){
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e){}
        saldo -= _valor;
    }
}
