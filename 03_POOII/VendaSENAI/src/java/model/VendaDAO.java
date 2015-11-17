package model;

import dto.tbProdutoDTO;
import dto.tbVendaDTO;
import dto.tbVendedorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VendaDAO extends daoUtil{
    private VendedorDAO vendedordao = new VendedorDAO();
    private ProdutoDAO produtodao = new ProdutoDAO();
    
    public VendaDAO() {
        super();
    }
    
    public boolean adicionar (tbVendaDTO venda) throws SQLException, ClassNotFoundException{
        int idvenda = super.getMaxId("SELECT MAX(idVenda)+1 FROM tbVenda");

        PreparedStatement ps = super.getPreparedStatement("INSERT INTO tbVenda "
                + "(idVenda, idVendedor, idProduto, qtQuantidade) "
                + " VALUES (?,?,?,?)");
        
        ps.setInt(1, idvenda);
        ps.setInt(2, venda.getVendedor().getIdvendedor());
        ps.setInt(3, venda.getProduto().getIdproduto());
        ps.setInt(4, venda.getQtquantidade());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        
        venda.getProduto().setQtestoque(venda.getQtquantidade());
        produtodao.setAlterarEstoque(venda.getProduto());
        
        return ret >0;
    }
    
    public boolean alterar(tbVendaDTO venda) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE tbVenda SET "
                                    + "idVendedor = ?, "
                                    + "idProduto = ?, "
                                    + "qtQuantidade = ?, "
                                    + "WHERE idVenda = ?");
        ps.setInt(1, venda.getVendedor().getIdvendedor());
        ps.setInt(2, venda.getProduto().getIdproduto());
        ps.setInt(3, venda.getQtquantidade());
        ps.setInt(4, venda.getIdvenda());
        
        int ret = ps.executeUpdate();
        //produtodao.setAlterarEstoque(venda.getProduto());
        ps.close();
        super.getFechaTudo();
        return ret >0;
    }
    public boolean excluir(tbVendaDTO venda) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM tbVenda "
                                    + "WHERE idVenda = ?");
        ps.setInt(1, venda.getIdvenda());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret >0;
    }
    
    public tbVendaDTO getVendaPorId(tbVendaDTO venda) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM tbVenda "
                                    + "WHERE idVenda = ?");
        ps.setInt(1, venda.getIdvenda());
        ResultSet rs = ps.executeQuery();
        if(!rs.next()){
            rs.close();
            ps.close();
            super.getFechaTudo();
            return null;
        }
        
        tbVendedorDTO vendedor = vendedordao.getVendedorPorID(new tbVendedorDTO(rs.getInt("idVendedor"),null,null));
        tbProdutoDTO produto = produtodao.getPorId(new tbProdutoDTO(rs.getInt("idProduto"), null,null,0,0));
        tbVendaDTO vendaRet = new tbVendaDTO(rs.getInt("idVenda"), vendedor, produto, rs.getInt("qtQuantidade"));
        rs.close();
        ps.close();
        super.getFechaTudo();
        return vendaRet;
    }
    
    public List<tbVendaDTO> getTodasAsVendas() throws ClassNotFoundException, SQLException{
        List<tbVendaDTO> todasasvendas = new LinkedList<tbVendaDTO>();
        
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM tbVenda ");
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            tbVendedorDTO vendedor = vendedordao.getVendedorPorID(new tbVendedorDTO(rs.getInt("idVendedor"),null,null));
            tbProdutoDTO produto = produtodao.getPorId(new tbProdutoDTO(rs.getInt("idProduto"), null,null,0,0));
            todasasvendas.add(new tbVendaDTO(rs.getInt("idVenda"), vendedor, produto, rs.getInt("qtQuantidade")));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todasasvendas;
    }
    
    public List<tbVendaDTO> getTodasAsVendasPorVendedor(tbVendedorDTO vendedor) throws ClassNotFoundException, SQLException{
        List<tbVendaDTO> todasasvendas = new LinkedList<tbVendaDTO>();
        
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM tbVenda WHERE idVendedor = ?");
        ps.setInt(1, vendedor.getIdvendedor());
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            tbProdutoDTO produto = produtodao.getPorId(new tbProdutoDTO(rs.getInt("idProduto"), null,null,0,0));
            todasasvendas.add(new tbVendaDTO(rs.getInt("idVenda"), vendedor, produto, rs.getInt("qtQuantidade")));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todasasvendas;
    }
}
