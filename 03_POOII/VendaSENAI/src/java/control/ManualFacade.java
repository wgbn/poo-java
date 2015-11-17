package control;

import dto.tbManualDTO;
import dto.tbProdutoDTO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ManualDAO;

@ManagedBean
@SessionScoped
public class ManualFacade {
    private List<tbManualDTO> manuais = new LinkedList<tbManualDTO>();
    private tbManualDTO manualselecionado;
    private ManualDAO manualDAO = new ManualDAO();
    private tbProdutoDTO produto;
    
    public ManualFacade(){
        this.manuais = null;
    }

    public tbProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(tbProdutoDTO produto) {
        this.produto = produto;
    }

    public List<tbManualDTO> getManuais() throws ClassNotFoundException, SQLException {
        if (this.produto.getIdproduto() > 0)
            this.manuais = manualDAO.getTodosOsManuaisPorProduto(produto);
        return this.manuais;
    }

    public tbManualDTO getManualselecionado() {
        return manualselecionado;
    }

    public void setManualselecionado(tbManualDTO manualselecionado) {
        this.manualselecionado = manualselecionado;
    }
    
    public String vaiParaEditarManual(){
        return "ManualEditar";
    }
    
    public String voltaProProduto(){
        return "ProdutoVisualizar";
    }
    
    public String deletarManual() throws ClassNotFoundException, SQLException{
        this.manualDAO.excluir(manualselecionado);
        return this.voltaProProduto();
    }
    
    public String preparaCadastrarManual(){
        this.manualselecionado = new tbManualDTO();
        this.manualselecionado.setProduto(produto);
        return "ManualCadastrar";
    }
    
    public String alterarManual() throws ClassNotFoundException, SQLException{
        this.manualDAO.alterar(manualselecionado);
        return this.voltaProProduto();
    }
    
    public String finalizarManual() throws SQLException, ClassNotFoundException{
        this.manualDAO.adicionar(manualselecionado);
        return this.voltaProProduto();
    }
}
