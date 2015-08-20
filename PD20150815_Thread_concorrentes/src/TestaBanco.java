/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author walter
 */
public class TestaBanco {
    public static void main(String[] args) {
        Conta cc = new Conta();
        cc.depositar(100);
        
        Banco bb = new Banco(cc);
        Thread andreCC = new Thread(bb, "André");
        Thread elineiCC = new Thread(bb, "Elinei");
        
        andreCC.start();
        elineiCC.start();
    }
}
