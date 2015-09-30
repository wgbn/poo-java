/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public abstract class DaoUtil {
    
    private Connection cx = null;
    private String tabela;
    private String campoId;
    
    public DaoUtil(String tabela, String campoId){
        this.tabela = tabela;
        this.campoId = campoId;
    }
    
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
    
    protected int getMaxId() throws ClassNotFoundException, SQLException {
        int retId = 1;
        PreparedStatement ps = this.getPrepareStatement("select max(?)+1 from ?");
        ps.setString(1, this.tabela);
        ps.setString(2, this.campoId);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
            if (rs.getInt(1) > 0)
                retId = rs.getInt(1);
        
        return retId;
    }
    
    public abstract boolean adicionar(Object obj) throws SQLException, ClassNotFoundException;
    public abstract boolean alterar(Object obj) throws SQLException, ClassNotFoundException;
    public abstract boolean excluir(Object obj) throws SQLException, ClassNotFoundException;
    public abstract Object getPorId(Object obj) throws SQLException, ClassNotFoundException;
    public abstract List getTodos() throws SQLException, ClassNotFoundException;
}
