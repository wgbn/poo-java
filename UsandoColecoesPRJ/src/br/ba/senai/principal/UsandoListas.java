/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.senai.principal;

import br.ba.senai.beans.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author André Portugal
 */
public class UsandoListas {
    public static void main(String[] args) {
        List<Aluno> alunos;
        alunos = new ArrayList<Aluno>();
        Scanner tec = new Scanner(System.in);
        Aluno aluno = new Aluno(tec.next(), tec.nextInt());
        for (int i = 1; i <= 4; i++) {
            alunos.add(aluno);
        }
        for(Aluno a:alunos){
            System.out.println("Nome:"+a.getNome());
            System.out.println("Idade:"+a.getIdade());
        }
        alunos.remove(2);
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("Nome:"+alunos.get(i).getNome());
        }
        
        int res = alunos.get(0).getIdade()>20?0:1;
        if (alunos.get(0).getIdade()>20)
            res = 0;
        else
            res=1;
        
        System.out.println("Resultado:"+res);
    }
}
