package br.com.wgbn.sgap.dao;

import java.util.List;

/**
 * Created by Walter Gandarella
 */
public interface IF_DAO<T> {
    void salvar(T object);
    void alterar(T object);
    void excluir(T object);
    List<T> getTodos();
    T getPorPk(int pk);
}
