/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.fieb.senai.cimatec.pd.telas;

import java.util.Scanner;

/**
 *
 * @author walter
 */
public class Principal {
    public static void main(String[] args){
        
        try {
            String nome;
            Scanner tec = new Scanner(System.in);
            int v1 = tec.nextInt();
            int v2 = Integer.parseInt(tec.next());
            int res = v1/v2;
            System.out.println("Resultado: "+res);
        } catch (NumberFormatException e) {
            System.out.println("Não digite letra!");
            e.printStackTrace();
        }
        
    }
}