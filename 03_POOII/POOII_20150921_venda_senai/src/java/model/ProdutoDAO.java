package model;

import dto.TbProdutoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author root
 */
public class ProdutoDAO extends DaoUtil {
    
    public ProdutoDAO(){
        super();
    }
    
    public boolean adicionar(TbProdutoDTO produto) throws ClassNotFoundException, SQLException {
        int idproduto = this.getMaxId("TBPRODUTO","IDPRODUTO");
        PreparedStatement ps = super.getPrepareStatement("insert into TBPRODUTO (IDPRODUTO, DESCRICAO, FABRICANTE, QTESTOQUE, VLPRECO) values (?, ?, ?, ?, ?)");
        ps.setInt(1, idproduto);
        ps.setString(2, produto.getDescricao());
        ps.setString(3, produto.getFabricante());
        ps.setInt(4, produto.getQtestoque());
        ps.setFloat(5, produto.getVlpreco());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.fechaTudo();
        
        return ret > 0;
    }
    
    public boolean alterar(TbProdutoDTO produto) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = super.getPrepareStatement("update TBPRODUTO set DESCRICAO = ?, FABRICANTE = ?, QTESTOQUE = ?, VLPRECO = ? where IDPRODUTO = ?");
        ps.setString(1, produto.getDescricao());
        ps.setString(2, produto.getFabricante());
        ps.setInt(3, produto.getQtestoque());
        ps.setFloat(4, produto.getVlpreco());
        ps.setInt(5, produto.getIdproduto());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.fechaTudo();
        
        return ret > 0;
    }
    
    public boolean excluir(TbProdutoDTO produto) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = super.getPrepareStatement("delete from TBPRODUTO where IDPRODUTO = ?");
        ps.setInt(1, produto.getIdproduto());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.fechaTudo();
        
        return ret > 0;
    }
    
    public TbProdutoDTO getPorId(TbProdutoDTO produto) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPrepareStatement("select * from TBPRODUTO where IDPRODUTO = ?");
        ps.setInt(1, produto.getIdproduto());
        
        TbProdutoDTO res = null;
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())        
            res = new TbProdutoDTO(rs.getInt("IDPRODUTO"), rs.getString("DESCRICAO"), rs.getString("FABRICANTE"), rs.getInt("QTESTOQUE"), rs.getFloat("VLPRECO"));
        
        rs.close();
        ps.close();
        super.fechaTudo();
        
        return res;
    }
    
    public List getTodos() throws SQLException, ClassNotFoundException {
        List<TbProdutoDTO> todosOsProdutos = new LinkedList<TbProdutoDTO>();
        PreparedStatement ps = super.getPrepareStatement("select * from TBPRODUTO");
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
            while (rs.next())
                todosOsProdutos.add(new TbProdutoDTO(rs.getInt("IDPRODUTO"), rs.getString("DESCRICAO"), rs.getString("FABRICANTE"), rs.getInt("QTESTOQUE"), rs.getFloat("VLPRECO")));
        
        rs.close();
        ps.close();
        super.fechaTudo();
        
        return todosOsProdutos;
    }
    
    public boolean setAlterarEstoque(TbProdutoDTO produto) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = super.getPrepareStatement("update TBPRODUTO set QTESTOQUE = QTESTOQUE - "+produto.getQtestoque()+" where IDPRODUTO = "+produto.getIdproduto());
        int ret = ps.executeUpdate();
        ps.close();
        super.fechaTudo();
        
        return ret > 0;
    }
    
    public boolean setAlterarEstoqueMetodoWalter(TbProdutoDTO produto) throws SQLException, ClassNotFoundException {
        TbProdutoDTO original = this.getPorId(produto);
        int ret = 0;
        
        if (original != null){
            produto.setQtestoque(original.getQtestoque() - produto.getQtestoque());
            return this.alterar(produto);
        }
        
        return ret > 0;
    }
    
}
