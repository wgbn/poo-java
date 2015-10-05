/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.util;

import br.ba.poo2.dao.AlunoDAO;
import br.ba.poo2.dao.AlunoDAOListener;

/**
 *
 * @author André Portugal
 */
public class FabricaDAO {

    public static AlunoDAOListener criarAlunoDAO(){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return alunoDAO;
    }
}
