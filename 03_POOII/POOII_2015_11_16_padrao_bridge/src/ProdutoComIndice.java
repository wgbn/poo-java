/**
 * Created by walter on 16/11/15.
 */
public class ProdutoComIndice extends DataAccess {
    private String conteudo;
    private int i = 1;
    public ProdutoComIndice(){}

    @Override
    public void criar(String _nome) {
        conteudo += "\n" + i + " : " + _nome;
        i++;
    }

    @Override
    public String imprimir() {
        return conteudo;
    }
}
