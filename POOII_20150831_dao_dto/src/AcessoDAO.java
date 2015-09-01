import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class AcessoDAO implements InterfaceAcessoDAO {
    private String login    = "";
    private String password = "";
    private String driver   = "org.sqlite.JDBC";
    private String url      = "jdbc:sqlite:///home/walter/workspace/java/poo/POOII_20150831_dao_dto/pessoas.db";
    private Connection connection;

    public AcessoDAO(){}

    private void startConection() {
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

    private void destroyConection() {
        try {
            this.connection.close();
        } catch (SQLException sqle) {
            System.err.println("Erro ao tentar fechar o banco de dados\n" + sqle);
        }
    }

    @Override
    public Collection recuperaRegistroComParametros(String _nome){
        String sql = "select codigo, nome, bairro from pessoas where nome like ?";
        List retorno = new ArrayList();

        startConection();

        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, "%"+_nome+"%");

            ResultSet rs = prepare.executeQuery();

            while(rs.next()){
                retorno.add(new TbPessoaDTO(rs.getInt("codigo"), rs.getString("nome"), rs.getString("bairro")));
            }

            rs.close();
            prepare.close();

        } catch (SQLException e){
            System.err.println("Erro: "+e.getMessage());
        }

        destroyConection();

        return retorno;
    }

    @Override
    public String recuperaRegistroPorPK(int _pk){
        String sql = "select nome from pessoas where codigo = ?";
        String nome = "";

        startConection();

        try{
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, _pk);

            ResultSet rs = prepare.executeQuery();

            while (rs.next()){
                nome = rs.getString("nome");
            }

            rs.close();
            prepare.close();
        } catch (SQLException e){
            System.out.println("\nError message: "+e.getMessage());
        }

        destroyConection();

        return nome;
    }
}
