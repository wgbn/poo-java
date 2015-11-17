package model;

import dto.tbProdutoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ProdutoDAO extends daoUtil{

    public ProdutoDAO() {
        super();
    }
    
    public boolean adicionar(tbProdutoDTO produto) throws SQLException, ClassNotFoundException{
        int idproduto = super.getMaxId("SELECT MAX(idproduto)+1 FROM tbProduto");
        PreparedStatement ps = super.getPreparedStatement("INSERT INTO TBPRODUTO "
                            + "(IDPRODUTO, "
                            + "DESCRICAO,  "
                            + "FABRICANTE, "
                            + "QTESTOQUE, "
                            + "VLPRECO) "
                            + "VALUES (?,?,?,?,?)");
        ps.setInt(1, idproduto);
        ps.setString(2, produto.getDsecricao());
        ps.setString(3, produto.getFabricante());
        ps.setInt(4, produto.getQtestoque());
        ps.setFloat(5, produto.getVlpreco());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return  ret >0;
    }
    
    public boolean alterar(tbProdutoDTO produto) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE TBPRODUTO SET "
                                    + "DESCRICAO = ?, "
                                    + "FABRICANTE = ?, "
                                    + "QTESTOQUE = ?, "
                                    + "VLPRECO = ? "
                                    + "WHERE IDPRODUTO = ?");
        
        ps.setString(1, produto.getDsecricao());
        ps.setString(2, produto.getFabricante());
        ps.setInt(3, produto.getQtestoque());
        ps.setFloat(4, produto.getVlpreco());
        ps.setInt(5, produto.getIdproduto());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return  ret >0;
    }
    
    public boolean excluir(tbProdutoDTO produto) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM TBPRODUTO "
                               + "WHERE IDPRODUTO = ?");
        ps.setInt(1, produto.getIdproduto());
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return  ret >0;
    }
    
    public tbProdutoDTO getPorId(tbProdutoDTO produto) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TBPRODUTO "
                               + "WHERE IDPRODUTO = ?");
        ps.setInt(1, produto.getIdproduto());
        ResultSet rs = ps.executeQuery();
        if(!rs.next()){
            rs.close();
            ps.close();
            super.getFechaTudo();
            return null;
        }
        tbProdutoDTO proRet = new tbProdutoDTO(rs.getInt("IDPRODUTO"),
                            rs.getString("DESCICAO"),
                            rs.getString("FABRICANTE"),
                            rs.getInt("QTESTOQUE"),
                            rs.getFloat("VLPRECO"));
        rs.close();
        ps.close();
        super.getFechaTudo();
        return proRet;
    }
    
    public List<tbProdutoDTO> getTodos()throws SQLException, ClassNotFoundException{
        List<tbProdutoDTO> todosOsProdutos = new LinkedList<tbProdutoDTO>();
        
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TBPRODUTO ");
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            todosOsProdutos.add( new tbProdutoDTO(rs.getInt("IDPRODUTO"),
                                                  rs.getString("DESCRICAO"),
                                                  rs.getString("FABRICANTE"),
                                                  rs.getInt("QTESTOQUE"),
                                                  rs.getFloat("VLPRECO")) );
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todosOsProdutos;
    }
    
    public boolean setAlterarEstoque(tbProdutoDTO produto) throws ClassNotFoundException, SQLException{
        String sSQL = "UPDATE TBPRODUTO " +
                      "SET QTESTOQUE = QTESTOQUE - " + produto.getQtestoque() +
                      " WHERE IDPRODUTO = " + produto.getIdproduto();
        int ret = 0;
        try {
            Statement st = getStatement();
            ret = st.executeUpdate(sSQL);
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println(classNotFoundException.getMessage());
        }
        return  ret > 0;
    }

}