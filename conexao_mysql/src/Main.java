import java.sql.Connection;

/**
 * Created by walter on 28/08/15.
 */
public class Main {
    public static void main(String[] args) {
        ConexaoMySql conn = ConexaoMySql.getConexaoMySql();
        System.out.println(conn.statusConnection());
    }
}
