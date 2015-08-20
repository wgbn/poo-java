/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.senai.principal;

import br.ba.senai.beans.Aluno;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author André Portugal
 */
public class UsandoMapas {
    public static void main(String[] args) {
        //Map<String,String> mapa = new TreeMap<String, String>();
        Map<Integer,Aluno> mapa2 = new HashMap<Integer, Aluno>();
        Scanner tec = new Scanner(System.in);
        //System.out.println("Mapa de Strings............");        
        //for (int i = 1; i <= 4; i++) {
          //  mapa.put(tec.next(), tec.next());
       // }
        System.out.println("Mapa de Alunos............");
        for (int i = 1; i <= 4; i++) {
            mapa2.put(new Integer(i), new Aluno(tec.next(), tec.nextInt()));
        }
//        for(String chave:mapa.keySet()){
  //          System.out.println("Chave:"+chave);
    //        System.out.println("Valor:"+mapa.get(String.valueOf(chave)));
      //  }
       for(Integer chave:mapa2.keySet()){
            System.out.println("Chave:"+chave);
            System.out.println("Valor:"+mapa2.get(chave).getNome());
        }
//        Iterator entradas = mapa.entrySet().iterator();
//        while (entradas.hasNext()){
//            Map.Entry entrada = (Map.Entry) entradas.next();
//            System.out.println("Chave:"+entrada.getKey());
//            System.out.println("Valor:"+entrada.getValue());
//        }
        
    }
}
