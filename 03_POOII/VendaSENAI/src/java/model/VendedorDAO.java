package model;

import dto.tbVendedorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class VendedorDAO extends daoUtil{

    public VendedorDAO() {
        super();
    }

    public boolean adicionar(tbVendedorDTO vendedor) throws SQLException, ClassNotFoundException{
        int idVendedor = super.getMaxId("SELECT MAX(IDVENDEDOR)+1 FROM tbVendedor");
        
        PreparedStatement ps = super.getPreparedStatement("INSERT INTO TBVENDEDOR "
                + "(IDVENDEDOR, NOMEVENDEDOR, DTNASCIMENTO) "
                + " VALUES (?,?,?)");
        ps.setInt(1, idVendedor);
        ps.setString(2, vendedor.getNomevendedor());
        ps.setDate(3, new java.sql.Date(vendedor.getDtnascimento().getTime()));
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret >0;
    }
    
    public boolean alterar(tbVendedorDTO vendedor) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE TBVENDEDOR SET "
                                    + "NOMEVENDEDOR = ?, "
                                    + "DTNASCIMENTO = ?, "
                                    + "WHERE IDVENDEDOR = ?");
        
        ps.setString(1, vendedor.getNomevendedor());
        ps.setDate(2, new java.sql.Date(vendedor.getDtnascimento().getTime()));
        ps.setInt(3, vendedor.getIdvendedor());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return  ret >0;
    }
    
    public boolean excluir(tbVendedorDTO vendedor) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM "
                + "TBVENDEDOR "
                + "WHERE IDVENDEDOR = ?");

        ps.setInt(1, vendedor.getIdvendedor());

        int retorno = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return retorno > 0;
    }
    
    public tbVendedorDTO getVendedorPorID(tbVendedorDTO vendedor) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = super.getPreparedStatement("SELECT IDVENDEDOR, "
                + "NOMEVENDEDOR, DTNASCIMENTO "
                + "FROM TBVENDEDOR WHERE IDVENDEDOR = ?");

        ps.setInt(1, vendedor.getIdvendedor());
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            ps.close();
            rs.close();
            super.getFechaTudo();
            return null;
        }
        tbVendedorDTO vendRetorno = new tbVendedorDTO(rs.getInt("IDVENDEDOR"),
                                                      rs.getString("NOMEVENDEDOR"),
                                                      rs.getDate("DTNASCIMENTO") );
        ps.close();
        rs.close();
        super.getFechaTudo();
        return vendRetorno;
    }
    
    public List<tbVendedorDTO> getTodosOsVendedores() throws ClassNotFoundException, SQLException {
        List<tbVendedorDTO> listaDeVendedores = new LinkedList<tbVendedorDTO>();

        ResultSet rs = super.getStatement().executeQuery("SELECT * FROM TBVENDEDOR");
        while (rs.next()) {
            listaDeVendedores.add(new tbVendedorDTO(rs.getInt("IDVENDEDOR"),
                                                    rs.getString("NOMEVENDEDOR"),
                                                    rs.getDate("DTNASCIMENTO")) );
        }
        rs.close();
        super.getFechaTudo();
        return listaDeVendedores;
    }
}
