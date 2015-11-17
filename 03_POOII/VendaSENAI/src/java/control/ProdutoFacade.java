package control;

import dto.tbProdutoDTO;
import java.sql.SQLException;
import java.util.List;
import model.ProdutoDAO;

public class ProdutoFacade {
    private ProdutoDAO prodDAO = new ProdutoDAO();
    private tbProdutoDTO produtoselecionado;
    private List<tbProdutoDTO> produtos;
    private int idCombo;

    public String preparaParaIncluir(){
        produtoselecionado = new tbProdutoDTO();
        return "vaiParaIncluir";
    }
    
    public String alteraProduto() throws SQLException, ClassNotFoundException{
        prodDAO.alterar(produtoselecionado);
        produtos = null;
        return "VoltaParaListar";
    }
    public String deletaProduto() throws SQLException, ClassNotFoundException{
        prodDAO.excluir(produtoselecionado);
        produtos = null;
        return "refresh";        
    }
    
    public String finalizaProduto() throws SQLException, ClassNotFoundException{
        produtos = null;
        prodDAO.adicionar(produtoselecionado);
        return "VoltaParaListar";
    }
    
    public void consultaProduto() throws SQLException, ClassNotFoundException{
        produtoselecionado = prodDAO.getPorId(produtoselecionado);
    }
    
    public ProdutoFacade() {
        produtos = null;
    }

    public tbProdutoDTO getProdutoselecionado() {
        return produtoselecionado;
    }

    public void setProdutoselecionado(tbProdutoDTO produtoselecionado) {
        this.produtoselecionado = produtoselecionado;
    }

    public List<tbProdutoDTO> getProdutos() throws SQLException, ClassNotFoundException {
        produtos = null;
        produtos = prodDAO.getTodos();
        return produtos;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }
    
}
