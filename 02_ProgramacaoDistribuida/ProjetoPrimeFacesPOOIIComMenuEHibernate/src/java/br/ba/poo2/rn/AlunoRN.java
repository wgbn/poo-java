/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.rn;

import br.ba.poo2.dao.AlunoDAOListener;
import br.ba.poo2.mapeamento.Aluno;
import br.ba.poo2.util.FabricaDAO;
import java.util.List;

/**
 *
 * @author André Portugal
 */
public class AlunoRN {
    private AlunoDAOListener alunoDao;
    public AlunoRN() {
        this.alunoDao = FabricaDAO.criarAlunoDAO();
    }
    public void alterar(Aluno al){
        this.alunoDao.alterar(al);
    }
    public Aluno buscarAlunoporNome(String nome){
        return this.alunoDao.buscarAlunoporNome(nome);
    }
    public Aluno consultar(int matricula){
        return this.alunoDao.consultar(matricula);
    }
    public void excluir(Aluno al){
        this.alunoDao.excluir(al);
    }
    public List<Aluno> listarAlunosPorLike(String part){
        return this.alunoDao.listarAlunosPorLike(part);
    }
    public List<Aluno> listarAlunosporFaixa(int ini, int fim){
        return this.alunoDao.listarAlunosporFaixa(ini, fim);
    }
    public List<Aluno> listarSemFiltro(){
        return this.alunoDao.listarSemFiltro();
    }
    public void salvar(Aluno al){
        this.alunoDao.salvar(al);
    }
}
