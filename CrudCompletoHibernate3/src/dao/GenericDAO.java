package dao;

import entity.PessoaEntity;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {
    private EntityManager entityManager;

    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T getByPk(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    public void insert(T entity) {
        //entityManager.persist(entity);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void update(T entity) {
        //entityManager.merge(entity);
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(T entity) {
        //entityManager.remove(entity);
        try {
            entityManager.getTransaction().begin();
            //entity = entityManager.find(getTypeClass(), entity.getId());
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteByPk(final PK id) {
        try {
            T entity = getByPk(id);
            delete(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
