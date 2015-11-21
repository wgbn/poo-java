package br.com.wgbn.sgap.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadeEntityManager {
    private EntityManager entityManager;
    private EntityManagerFactory factory;

    public FacadeEntityManager(EntityManagerFactory factory) {
        this.factory = factory;
        this.entityManager = factory.createEntityManager();
    }

    public FacadeEntityManager(String persistenceUnitName){
        this.factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.entityManager = this.factory.createEntityManager();
    }

    public void beginTransaction(){
        this.entityManager.getTransaction().begin();
    }

    public void commit(){
        this.entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.factory.close();
    }

    public void rollBack(){
        this.entityManager.getTransaction().rollback();
    }

    public EntityManager getEntityManager(){
        return this.entityManager;
    }
}
