package model;

import dto.tbManualDTO;
import dto.tbProdutoDTO;
import dto.tbVendaDTO;
import dto.tbVendedorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ManualDAO extends daoUtil {
    private ProdutoDAO produtodao = new ProdutoDAO();
    
    public ManualDAO(){
        super();
    }
    
    public boolean adicionar (tbManualDTO manual) throws SQLException, ClassNotFoundException{
        int idmanual = super.getMaxId("SELECT MAX(idManual) + 1 FROM tbManual");

        PreparedStatement ps = super.getPreparedStatement("INSERT INTO tbManual "
                + "(idManual, idProduto, dsInstrucao, dtValidade) "
                + " VALUES (?,?,?,?)");
        
        ps.setInt(1, idmanual);
        ps.setInt(2, manual.getProduto().getIdproduto());
        ps.setString(3, manual.getDsinstrucao());
        ps.setDate(4, new java.sql.Date(manual.getDtvalidade().getTime()));
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        
        return ret > 0;
    }
    
    public boolean alterar(tbManualDTO manual) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE tbManual SET "
                                    + "idProduto = ?, "
                                    + "dsInstrucao = ?, "
                                    + "dtValidade = ? "
                                    + "WHERE idManual = ?");
        ps.setInt(1, manual.getProduto().getIdproduto());
        ps.setString(2, manual.getDsinstrucao());
        ps.setDate(3, new java.sql.Date(manual.getDtvalidade().getTime()));
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }
    
    public boolean excluir(tbManualDTO manual) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM tbManual "
                                    + "WHERE idManual = ?");
        ps.setInt(1, manual.getIdmanual());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }
    
    public tbManualDTO getManualPorId(tbManualDTO manual) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM tbManual "
                                    + "WHERE idManual = ?");
        ps.setInt(1, manual.getIdmanual());
        ResultSet rs = ps.executeQuery();
        if(!rs.next()){
            rs.close();
            ps.close();
            super.getFechaTudo();
            return null;
        }

        tbProdutoDTO produto = produtodao.getPorId(new tbProdutoDTO(rs.getInt("idProduto"), null,null,0,0));
        tbManualDTO manualResult = new tbManualDTO(rs.getInt("idManual"), produto, rs.getString("dsInstrucao"), rs.getDate("dtValidade"));
        rs.close();
        ps.close();
        super.getFechaTudo();
        return manualResult;
    }
    
    public List<tbManualDTO> getTodosOsManuais() throws ClassNotFoundException, SQLException{
        List<tbManualDTO> todos = new LinkedList<tbManualDTO>();
        
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM tbManual");
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            tbProdutoDTO produto = produtodao.getPorId(new tbProdutoDTO(rs.getInt("idProduto"), null,null,0,0));
            todos.add(new tbManualDTO(rs.getInt("idManual"), produto, rs.getString("dsInstrucao"), rs.getDate("dtValidade")));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todos;
    }
    
    public List<tbManualDTO> getTodosOsManuaisPorProduto(tbProdutoDTO produto) throws ClassNotFoundException, SQLException{
        List<tbManualDTO> todos = new LinkedList<tbManualDTO>();
        
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM tbManual WHERE idProduto = ?");
        ps.setInt(1, produto.getIdproduto());
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            todos.add(new tbManualDTO(rs.getInt("idManual"), produto, rs.getString("dsInstrucao"), rs.getDate("dtValidade")));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todos;
    }
}
