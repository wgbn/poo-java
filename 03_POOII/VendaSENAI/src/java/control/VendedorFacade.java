package control;

import dto.tbVendedorDTO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.VendedorDAO;


@ManagedBean
@SessionScoped
public class VendedorFacade {
    private VendedorDAO vendedorDAO = new VendedorDAO();
    private tbVendedorDTO vendedorSelecionado;
    private List<tbVendedorDTO> vendedores;
    private int idCombo;

    public tbVendedorDTO getVendedorSelecionado() {
        return vendedorSelecionado;
    }
    public String preparaParaIncluir(){
        vendedorSelecionado = new tbVendedorDTO();
        return "vaiParaIncluir";
    }
    
    public String alteraVendedor() throws SQLException, ClassNotFoundException{
        vendedorDAO.alterar(vendedorSelecionado);
        vendedores = null;
        return "VoltaParaListar";
    }
    
    public String finalizaVendedor() throws SQLException, ClassNotFoundException{
        vendedores = null;
        vendedorDAO.adicionar(vendedorSelecionado);
        return "VoltaParaListar";
    }
    
    public String deletaProduto() throws SQLException, ClassNotFoundException{
        vendedorDAO.excluir(vendedorSelecionado);
        vendedores = null;
        return "refresh";        
    }

    public void setVendedorSelecionado(tbVendedorDTO vendedorSelecionado) {
        this.vendedorSelecionado = vendedorSelecionado;
    }

    public List<tbVendedorDTO> getVendedores() throws ClassNotFoundException, SQLException {
         if (vendedores == null){
            vendedores =vendedorDAO.getTodosOsVendedores();
        }
        return vendedores;
    }

    public void setVendedores(List<tbVendedorDTO> vendedores) {
        this.vendedores = vendedores;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public VendedorFacade() {
        vendedores = null;
    }
}
