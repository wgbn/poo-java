package dao;

import entity.PessoaEntity;

import javax.persistence.EntityManager;

public class PessoaGDAO extends GenericDAO<Long, PessoaEntity> {
    public PessoaGDAO(EntityManager em){
        super(em);
    }
}
