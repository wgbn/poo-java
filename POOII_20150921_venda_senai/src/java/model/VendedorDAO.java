/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.TbProdutoDTO;
import dto.TbVendedorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author root
 */
public class VendedorDAO extends DaoUtil {
    
    public VendedorDAO(){
        super("TBVENDEDOR", "IDVENDEDOR");
    }

    public boolean adicionar(TbVendedorDTO vendedor) throws SQLException, ClassNotFoundException {
        int idvendedor = this.getMaxId();
        
        PreparedStatement ps = super.getPrepareStatement("insert into TBVENDEDOR (IDVENDEDOR, NOMEVENDEDOR, DTNASCIMENTO) values (?, ?, ?)");
        ps.setInt(1, idvendedor);
        ps.setString(2, vendedor.getNomevendedor());
        ps.setDate(3, new java.sql.Date(vendedor.getDtnascimento().getTime()));
        
        int ret = ps.executeUpdate();
        ps.close();
        super.fechaTudo();
        
        return ret > 0;
    }

    public boolean alterar(TbVendedorDTO vendedor) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPrepareStatement("update TBVENDEDOR set NOMEVENDEDOR = ?, DTNASCIMENTO = ? where IDVENDEDOR = ?");
        ps.setString(1, vendedor.getNomevendedor());
        ps.setDate(2, new java.sql.Date(vendedor.getDtnascimento().getTime()));
        
        int ret = ps.executeUpdate();
        ps.close();
        super.fechaTudo();
        
        return ret > 0;
    }

    public boolean excluir(TbVendedorDTO vendedor) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPrepareStatement("delete from TBVENDEDOR where IDVENDEDOR = ?");
        ps.setInt(1, vendedor.getIdvendedor());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.fechaTudo();
        
        return ret > 0;
    }

    public TbVendedorDTO getPorId(TbVendedorDTO vendedor) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPrepareStatement("select * from TBVENDEDOR where IDVENDEDOR = ?");
        ps.setInt(1, vendedor.getIdvendedor());
        
        TbVendedorDTO res = null;
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())        
            res = new TbVendedorDTO(rs.getInt("IDVENDEDOR"), rs.getString("NOMEVENDEDOR"), rs.getDate("DTNASCIMENTO"));
        
        rs.close();
        ps.close();
        super.fechaTudo();
        
        return res;
    }

    public List<TbVendedorDTO> getTodos() throws SQLException, ClassNotFoundException {
        List<TbVendedorDTO> todos = new LinkedList<TbVendedorDTO>();
        PreparedStatement ps = super.getPrepareStatement("select * from TBVENDEDOR");
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
            while (rs.next())
                todos.add(new TbVendedorDTO(rs.getInt("IDVENDEDOR"), rs.getString("NOMEVENDEDOR"), rs.getDate("DTNASCIMENTO")));
        
        rs.close();
        ps.close();
        super.fechaTudo();
        
        return todos;
    }
    
    
}
