package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class daoUtil {
    
    private Connection cx = null;

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
    
    public Statement getStatement() throws SQLException, ClassNotFoundException{
        return this.getConnection().createStatement();
    }
   
    public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        return this.getConnection().prepareStatement(sql);
    }
    
    
    public void getFechaTudo() throws SQLException{
        if(cx != null){
            cx.close();
            cx=null;
        }
    }
    
    public int getMaxId(String sqlMAX) throws SQLException, ClassNotFoundException{
        int retID = 1;
        PreparedStatement ps = getPreparedStatement(sqlMAX);
        ResultSet rs = ps.executeQuery();
        
        if(!rs.next()){
            retID = 1;
        }else{
            if(rs.getInt(1) == 0){
                retID=1;
            }else{
                retID=rs.getInt(1);
            }
        }
        rs.close();
        ps.close();
        getFechaTudo();
        return  retID;
    }
}
