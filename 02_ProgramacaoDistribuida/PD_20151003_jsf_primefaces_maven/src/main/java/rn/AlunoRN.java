package rn;

import dao.AlunoDAOListener;
import entity.TbAlunoEntity;
import util.FabricaDAO;

import java.util.List;

public class AlunoRN {
    private AlunoDAOListener alunoDao;
    public AlunoRN() {
        this.alunoDao = FabricaDAO.criarAlunoDAO();
    }
    public void alterar(TbAlunoEntity al){
        this.alunoDao.alterar(al);
    }
    public TbAlunoEntity buscarAlunoporNome(String nome){
        return this.alunoDao.buscarAlunoPorNome(nome);
    }
    public TbAlunoEntity consultar(int matricula){
        return this.alunoDao.consultar(matricula);
    }
    public void excluir(TbAlunoEntity al){
        this.alunoDao.excluir(al);
    }
    public List<TbAlunoEntity> listarAlunosPorLike(String part){
        return this.alunoDao.listarAlunosPorLike(part);
    }
    public List<TbAlunoEntity> listarAlunosporFaixa(int ini, int fim){
        return this.alunoDao.listarAlunosPorFaixa(ini, fim);
    }
    public List<TbAlunoEntity> listarSemFiltro(){
        return this.alunoDao.listaSemFiltro();
    }
    public void salvar(TbAlunoEntity al){
        this.alunoDao.salvar(al);
    }
}
