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
        if (this.produtos != null)
            this.produtos = this.produtodao.getTodos();
        return produtos;
    }

    public int getIdcombo() {
        return idcombo;
    }

    public void setIdcombo(int idcombo) {
        this.idcombo = idcombo;
    }
    
}
