package util;

import dao.AlunoDAO;
import dao.AlunoDAOListener;

public class FabricaDAO {

    public static AlunoDAOListener criarAlunoDAO(){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return alunoDAO;
    }
}