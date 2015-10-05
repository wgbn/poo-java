/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.dao;

import br.ba.poo2.mapeamento.Aluno;
import java.util.List;

/**
 *
 * @author André Portugal
 */
public interface AlunoDAOListener {

    void alterar(Aluno al);

    Aluno buscarAlunoporNome(String nome);

    Aluno consultar(int matricula);

    void excluir(Aluno al);

    List<Aluno> listarAlunosPorLike(String part);

    List<Aluno> listarAlunosporFaixa(int ini, int fim);

    List<Aluno> listarSemFiltro();

    void salvar(Aluno al);
    
    
}
