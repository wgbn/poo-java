/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author walter
 */
public class Banco implements Runnable {

    private Conta conta;
    private double saque = 25;
    
    public Banco(Conta _conta){
        this.conta = _conta;
    }
    
    @Override
    public void run() {
        this.conta.sacar(saque);
        String tNome = Thread.currentThread().getName();
        System.out.println("Saque de "+saque+" efetuado (por: "+tNome+")\nSaldo = " + this.conta.saldo);
    }
    
}
