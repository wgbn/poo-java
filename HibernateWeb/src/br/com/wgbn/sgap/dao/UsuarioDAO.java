package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.UsuarioEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Walter Gandarella
 */
public class UsuarioDAO extends GenericoDAO<UsuarioEntity> {

    public UsuarioDAO(EntityManager em) {
        super(em);
    }

    public UsuarioEntity getPorNome(String nome){
        String query = "FROM " + getTypeClass().getName() + " WHERE nome = '" + nome + "'";
        return (UsuarioEntity) this.entityManager.createQuery(query).getSingleResult();
    }

    public List<UsuarioEntity> getTodosPorNome(String nome){
        String query = "FROM " + getTypeClass().getName() + " WHERE nome LIKE '%" + nome + "%' ORDER BY nome";
        return this.entityManager.createQuery(query).getResultList();
    }

    public List<UsuarioEntity> getTodosPorTipo(boolean gerente){
        String query = "FROM " + getTypeClass().getName() + " WHERE gerente = " + (gerente ? 1 : 0) + " ORDER BY nome";
        return this.entityManager.createQuery(query).getResultList();
    }
}