package controller;

import dto.TbVendaDTO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.VendaDAO;

/**
 *
 * @author Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class VendaFacade {

    private VendaDAO venda = new VendaDAO();
    private TbVendaDTO vendaSelecionada;
    private List<TbVendaDTO> vendas;
    
    public VendaFacade() {
    }

    public TbVendaDTO getVendaSelecionada() {
        return vendaSelecionada;
    }

    public void setVendaSelecionada(TbVendaDTO vendaSelecionada) {
        this.vendaSelecionada = vendaSelecionada;
    }

    public List<TbVendaDTO> getVendas() {
        return vendas;
    }
    
    public String preparaVenda(){
        this.vendaSelecionada = new TbVendaDTO();
        return "vaiParaVenda";
    }
    
    public String finalizaVenda() throws ClassNotFoundException, SQLException {
        this.venda.adicionar(this.vendaSelecionada);
        return "voltaVendaIndex";
    }
    
}
