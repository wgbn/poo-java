/**
 * Created by walter on 16/11/15.
 */
public class ProdutoSemIndice extends DataAccess {
    private String conteudo;
    public ProdutoSemIndice(){}

    @Override
    public void criar(String _nome) {
        conteudo += "\n" + _nome;
    }

    @Override
    public String imprimir() {
        return conteudo;
    }
}
