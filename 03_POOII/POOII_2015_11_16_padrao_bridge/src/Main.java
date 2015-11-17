/**
 * Created by walter on 16/11/15.
 */
public class Main {
    public static void main(String[] args) {
        // bridge
        ManagerBridge produtos = new ManagerBridge();
        DataAccess semIndice = new ProdutoSemIndice();
        DataAccess comIndice = new ProdutoComIndice();

        produtos.setAcesso(comIndice);
        produtos.inserir("Carro");
        produtos.inserir("Cavalo");
        produtos.inserir("Balão");
        produtos.inserir("Teclado");

        System.out.println(produtos.imprimir());
    }
}
