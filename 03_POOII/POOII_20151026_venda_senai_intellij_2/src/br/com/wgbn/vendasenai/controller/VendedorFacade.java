package br.com.wgbn.vendasenai.controller;

import br.com.wgbn.vendasenai.dto.TbVendedorDTO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.wgbn.vendasenai.model.VendedorDAO;

@ManagedBean
@SessionScoped
public class VendedorFacade {
    
    private VendedorDAO vendedorDAO = new VendedorDAO();
    private TbVendedorDTO vendedorSelecionado;
    private List<TbVendedorDTO> vendedores;
    private int idcombo;

    public VendedorFacade() {
        this.vendedores = null;
    }

    public List<TbVendedorDTO> getVendedores() throws SQLException, ClassNotFoundException {
        if (this.vendedores == null)
            this.vendedores = this.vendedorDAO.getTodos();
        return this.vendedores;
    }

    public TbVendedorDTO getVendedorSelecionado() {
        return vendedorSelecionado;
    }

    public void setVendedorSelecionado(TbVendedorDTO vendedorSelecionado) {
        this.vendedorSelecionado = vendedorSelecionado;
    }

    public int getIdcombo() {
        return idcombo;
    }

    public void setIdcombo(int idcombo) {
        this.idcombo = idcombo;
    }
    
    public String preparaParaIncluir(){
        this.vendedorSelecionado =  new TbVendedorDTO();
        return "vaiVendedorIncluir";
    }
    
    public String finalizaVendedor() throws ClassNotFoundException, SQLException {
        this.vendedores = null;
        
        this.vendedorDAO.adicionar(vendedorSelecionado);
        
        return "voltaVendedorLista";
    }
    
    public String alteraVendedor() throws ClassNotFoundException, SQLException {
        this.vendedorDAO.alterar(vendedorSelecionado);
        this.vendedores = null;
        return "voltaVendedorLista";
    }
    
    public String apagarVendedor() throws ClassNotFoundException, SQLException {
        this.vendedorDAO.excluir(vendedorSelecionado);
        this.vendedores = null;
        return "refreshVendedor";
    }
    
}
