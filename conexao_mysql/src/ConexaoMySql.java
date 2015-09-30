import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by walter on 28/08/15.
 */
public class ConexaoMySql {
    public static String status = "Não conectou...";
    private static ConexaoMySql conexaoMySql = null;
    private Connection conection = null;

    private ConexaoMySql(){
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            String server = "localhost";
            String database = "vivasalute";
            String url = "jdbc:mysql://"+server+"/"+database;
            String username = "root";
            String password = "theo0712";
            conection = DriverManager.getConnection(url, username, password);

            if (conection != null){
                status = ("STATUS ------> Conectado com sucesso");
            } else {
                status = ("STATUS ------> Conexão falhou");
            }
        } catch (ClassNotFoundException e){
            System.out.println("O driver não foi encontrado");
        } catch (SQLException e){
            System.out.println("Não foi possível conectar ao banco");
        }
    }

    public Connection getConection(){
        return conection;
    }

    public static ConexaoMySql getConexaoMySql(){
        if (conexaoMySql == null)
            conexaoMySql = new ConexaoMySql();

        return conexaoMySql;
    }

    public String statusConnection(){
        return status;
    }

    public boolean fecharConexao(){
        try {
            ConexaoMySql.getConexaoMySql().getConection().close();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    public ConexaoMySql reiniciarConexao(){
        fecharConexao();

        return ConexaoMySql.getConexaoMySql();
    }
}
