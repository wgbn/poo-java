public class Program {
    public static void main(String[] args) {

        AcessoBanco acessobanco = new AcessoBanco();
        System.out.println("\nIniciando Teste com o banco \n\n\n");
        System.out.println("Tentando abrir a conexão\n");
        acessobanco.criaAbreConexao();
        System.out.println("Conexão realizada com sucesso\n\n\n");
        System.out.println("Tentando fechar a conexão\n");
        acessobanco.recuperaRegistros();
        acessobanco.fechaConexao();
        System.out.println("Conexão finalizada... OK");

    }
}
