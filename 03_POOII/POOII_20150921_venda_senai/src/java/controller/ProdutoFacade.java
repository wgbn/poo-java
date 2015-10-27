package controller;

import dto.TbProdutoDTO;
import java.sql.SQLException;
import java.util.List;
import model.ProdutoDAO;

/**
 *
 * @author Walter Gandarella
 */
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