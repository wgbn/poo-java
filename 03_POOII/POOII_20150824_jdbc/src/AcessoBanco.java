import java.sql.*;

public class AcessoBanco {
    private String login    = "";
    private String password = "";
    private String driver   = "net.ucanaccess.jdbc.UcanaccessDriver";
    private String url      = "jdbc:ucanaccess:///home/walter/clientes.mdb";
    private Connection connection;

    public void criaAbreConexao() {
        try {
            Class.forName(this.driver);
            this.connection = DriverManager.getConnection(this.url, this.login, this.password);
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
            this.connection.close();
        } catch (SQLException sqle) {
            System.err.println("Erro ao tentar fechar o banco de dados\n" + sqle);
        }
    }

    public void recuperaRegistros(){
        String sql = "select codigo, nome from clientes";
        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt("codigo")+"\t"+rs.getString("nome"));
            }
            rs.close();
            st.close();
        } catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }
    }
}
