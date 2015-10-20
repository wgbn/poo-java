package dao;

import entity.TbAlunoEntity;

import java.util.List;

/**
 * Created by walter on 17/10/15.
 */
public interface AlunoDAOListener {
    void salvar(TbAlunoEntity _aluno);

    void alterar(TbAlunoEntity _aluno);

    void excluir(TbAlunoEntity _aluno);

    List<TbAlunoEntity> listaSemFiltro();

    TbAlunoEntity consultar(int _matricula);

    TbAlunoEntity buscarAlunoPorNome(String _nome);

    List<TbAlunoEntity> listarAlunosPorFaixa(int _ini, int _fin);

    List<TbAlunoEntity> listarAlunosPorLike(String _nome);
}
