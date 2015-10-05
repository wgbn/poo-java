package model;

import interfaces.IF_DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author root
 */
public abstract class DaoUtil implements IF_DAO {
    
    private Connection cx = null;
    
    public DaoUtil(){}
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (cx == null){
            String url = "jdbc:sqlite:/home/walter/workspace/java/poo/dbs/VendaSANAI.db";
            String login = "";
            String senha = "";
            Class.forName("org.sqlite.JDBC");
            cx = DriverManager.getConnection(url, login, senha);
        }
        
        return cx;
    }
    
    public Statement getStatement() throws ClassNotFoundException, SQLException {
        return this.getConnection().createStatement();
    }
    
    public PreparedStatement getPrepareStatement(String sql) throws ClassNotFoundException, SQLException {
        return this.getConnection().prepareStatement(sql);
    }
    
    public void fechaTudo() throws SQLException {
        if (cx != null){
            cx.close();
            cx = null;
        }
    }
    
    protected int getMaxId(String tabela, String campoId) throws ClassNotFoundException, SQLException {
        int retId = 1;
        PreparedStatement ps = this.getPrepareStatement("select max(?)+1 from ?");
        ps.setString(1, tabela);
        ps.setString(2, campoId);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
            if (rs.getInt(1) > 0)
                retId = rs.getInt(1);
        
        return retId;
    }

    @Override
    public boolean adicionar(Object obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Object obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Object obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getPorId(Object obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getTodos() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
