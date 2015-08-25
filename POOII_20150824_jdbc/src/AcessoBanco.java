import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessoBanco {
    private String login    = "";
    private String password = "";
    private String driver   = "sun.jdbc.odbc.JdbcOdbcDriver";
    private String url      = "jdbc:odbc:Driver={Microsoft Access (*.mdb)};DBQ=/home/walter/clientes.mdb";
    private Connection connection;

    public void criaAbreConexao() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Driver não encontrado\n" + cnfe);
        } catch (SQLException sqle) {
            System.err.println("Error ao criar a cconexão com o banco de dados\n");
            System.err.println("\nError Menssage: " + sqle.getMessage());
            System.err.println("\nError Cod.: " + sqle.getErrorCode());
            System.err.println("\nSQL State: " + sqle.getSQLState());
        } catch (Exception e) {
            System.err.println("Error\n" + e);
        }
    }

    public void fechaConexao() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            System.err.println("Erro ao tentar fechar o banco de dados\n" + sqle);
        }
    }
}
