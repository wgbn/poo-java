package br.com.wgbn.vendasenai.controller;

import br.com.wgbn.vendasenai.dto.*;
import java.sql.SQLException;
import java.util.List;
import br.com.wgbn.vendasenai.model.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class ProdutoFacade {
    
    private ProdutoDAO produtodao = new ProdutoDAO();
    private TbProdutoDTO produtoselecionado;
    private List<TbProdutoDTO> produtos;
    private int idcombo;

    public ProdutoFacade() {
        this.produtos = null;
    }

    public TbProdutoDTO getProdutoselecionado() {
        return produtoselecionado;
    }

    public void setProdutoselecionado(TbProdutoDTO produtoselecionado) {
        this.produtoselecionado = produtoselecionado;
    }

    public List<TbProdutoDTO> getProdutos() throws SQLException, ClassNotFoundException {
        //if (this.produtos == null)
            this.produtos = this.produtodao.getTodos();
        return produtos;
    }

    public int getIdcombo() {
        return idcombo;
    }

    public void setIdcombo(int idcombo) {
        this.idcombo = idcombo;
    }
    
    public String preparaParaIncluir(){
        this.produtoselecionado =  new TbProdutoDTO();
        //return "vaiIncluirProduto";
        return "ProdutoIncluir.xhtml";
    }
    
    public String finalizaProduto() throws ClassNotFoundException, SQLException {
        this.produtos = null;
        
        this.produtodao.adicionar(produtoselecionado);
        
        return "voltaProdutoListar";
    }
    
    public String alteraProduto() throws ClassNotFoundException, SQLException {
        if (this.produtodao.alterar(produtoselecionado)){
            this.produtos = null;
            return "voltaProdutoListar";
        }
        return "ProdutoEditar.xhtml?erro";
    }
    
    public String apagarProduto() throws ClassNotFoundException, SQLException {
        this.produtodao.excluir(produtoselecionado);
        this.produtos = null;
        return "refreshProduto";
    }
    
}