package model;

import dto.TbProdutoDTO;
import dto.TbVendaDTO;
import dto.TbVendedorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Walter Gandarella
 */
public class VendaDAO extends DaoUtil {
    
    private VendedorDAO vendedordao = new VendedorDAO();
    private ProdutoDAO produtodao = new ProdutoDAO();

    public VendaDAO() {
        super();
    }
    
    public boolean adicionar(TbVendaDTO venda) throws ClassNotFoundException, SQLException {
        int idvenda = this.getMaxId("TBVENDA","IDVENDA");
        PreparedStatement ps = super.getPrepareStatement("insert into TBVENDA (IDVENDA, IDVENDEDOR, IDPRODUTO, QTQUANTIDADE) values (?, ?, ?, ?)");
        ps.setInt(1, idvenda);
        ps.setInt(2, venda.getVendedor().getIdvendedor());
        ps.setInt(3, venda.getProduto().getIdproduto());
        ps.setInt(4, venda.getQtquantidade());
        
        int ret = ps.executeUpdate();
        ps.close();
        
        produtodao.setAlterarEstoque(venda.getProduto(),"-");
        
        super.fechaTudo();
        
        return ret > 0;
    }
    
    public boolean alterar(TbVendaDTO venda) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = super.getPrepareStatement("update TBVENDA set IDVENDEDOR = ?, IDPRODUTO = ?, QTQUANTIDADE = ? where IDVENDA = ?");
        ps.setInt(1, venda.getVendedor().getIdvendedor());
        ps.setInt(2, venda.getProduto().getIdproduto());
        ps.setInt(3, venda.getQtquantidade());
        
        int ret = ps.executeUpdate();
        ps.close();
        
        produtodao.setAlterarEstoque(venda.getProduto(),"-");
        
        super.fechaTudo();
        
        return ret > 0;
    }
    
    public boolean excluir(TbVendaDTO venda) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = super.getPrepareStatement("delete from TBVENDA where IDVENDA = ?");
        ps.setInt(1, venda.getIdvenda());
        
        int ret = ps.executeUpdate();
        ps.close();
        
        produtodao.setAlterarEstoque(venda.getProduto(),"+");
        
        super.fechaTudo();
        
        return ret > 0;
    }
    
    public TbVendaDTO getPorId(TbVendaDTO venda) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPrepareStatement("select * from TBVENDA where IDVENDA = ?");
        ps.setInt(1, venda.getIdvenda());
        
        TbVendaDTO res = null;
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()){
            TbVendedorDTO vendedor = new TbVendedorDTO(rs.getInt("IDVENDEDOR"));
            TbProdutoDTO produto = new TbProdutoDTO(rs.getInt("IDPRODUTO"));
            
            res = new TbVendaDTO(rs.getInt("IDVENDA"), vendedordao.getPorId(vendedor), produtodao.getPorId(produto), rs.getInt("QTQUANTIDADE"));
        }
        
        rs.close();
        ps.close();
        super.fechaTudo();
        
        return res;
    }
    
    public List getTodos() throws SQLException, ClassNotFoundException {
        List<TbVendaDTO> todasAsVendas = new LinkedList<TbVendaDTO>();
        PreparedStatement ps = super.getPrepareStatement("select * from TBVENDA");
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
            while (rs.next()){
                TbVendedorDTO vendedor = new TbVendedorDTO(rs.getInt("IDVENDEDOR"));
                TbProdutoDTO produto = new TbProdutoDTO(rs.getInt("IDPRODUTO"));
            
                todasAsVendas.add(new TbVendaDTO(rs.getInt("IDVENDA"), vendedordao.getPorId(vendedor), produtodao.getPorId(produto), rs.getInt("QTQUANTIDADE")));
            }
        
        rs.close();
        ps.close();
        super.fechaTudo();
        
        return todasAsVendas;
    }
}
