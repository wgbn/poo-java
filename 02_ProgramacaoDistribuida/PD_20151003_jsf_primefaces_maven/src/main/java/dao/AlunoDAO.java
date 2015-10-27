package dao;

import entity.TbAlunoEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AlunoDAO implements AlunoDAOListener {

    private Session sessao;

    public void setSessao(Session _sessao){
        this.sessao = _sessao;
    }

    public void salvar(TbAlunoEntity _aluno){
        this.sessao.save(_aluno);
    }

    public void alterar(TbAlunoEntity _aluno){
        this.sessao.update(_aluno);
    }

    public void excluir(TbAlunoEntity _aluno){
        this.sessao.delete(_aluno);
    }

    public List<TbAlunoEntity> listaSemFiltro(){
        return this.sessao.createCriteria(TbAlunoEntity.class).list();
    }

    public TbAlunoEntity consultar(int _matricula){
        return (TbAlunoEntity)this.sessao.get(TbAlunoEntity.class, _matricula);
    }

    public TbAlunoEntity buscarAlunoPorNome(String _nome){
        String hql = "select a from TbAlunoEntity a where a.nome = :nome";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setString("nome", _nome);
        return (TbAlunoEntity)consulta.uniqueResult();
    }

    public List<TbAlunoEntity> listarAlunosPorFaixa(int _ini, int _fin){
        String hql = "select a from TbAlunoEntity a where a.matricula >= :ini and a.matricula <= :fim";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setInteger("ini", _ini);
        consulta.setInteger("fim", _fin);
        return (List<TbAlunoEntity>)consulta.list();
    }

    public List<TbAlunoEntity> listarAlunosPorLike(String _nome){
        Criteria cri = this.sessao.createCriteria(TbAlunoEntity.class);
        cri.add(Restrictions.like("nome", "%"+_nome+"%"));
        return (List<TbAlunoEntity>)cri.list();
    }

}
