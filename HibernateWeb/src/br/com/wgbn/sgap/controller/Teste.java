package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.util.FacadeEntityManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by walter on 20/11/15.
 */
@ManagedBean(name = "testeBean")
@SessionScoped
public class Teste {

    private List<UsuarioEntity> usuarios = new LinkedList<UsuarioEntity>();
    private FacadeEntityManager fEntityManager = null;
    private UsuarioDAO usuarioDao = null;

    public Teste() {
        if (this.fEntityManager == null)
            this.fEntityManager = new FacadeEntityManager("wgbn");

        if (this.usuarioDao == null && this.fEntityManager != null)
            this.usuarioDao = new UsuarioDAO(this.fEntityManager.getEntityManager());
    }

    public List<UsuarioEntity> getUsuarios() {
        return this.usuarios;
    }
}
