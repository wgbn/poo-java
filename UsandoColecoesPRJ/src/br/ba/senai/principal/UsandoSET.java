/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.senai.principal;

import br.ba.senai.beans.Aluno;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author André Portugal
 */
public class UsandoSET {
    public static void main(String[] args) {
        Set<Aluno> alunos = new HashSet<Aluno>();
        Scanner tec = new Scanner(System.in);
        
        for (int i = 1; i < 4; i++) {
           Aluno aluno = new Aluno(tec.next(), tec.nextInt()); 
           alunos.add(aluno);
        }
        
        for(Aluno a:alunos){
            System.out.println("Nome:"+a.getNome());
            System.out.println("Idade:"+a.getIdade());
        }
    }
}
