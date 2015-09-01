import java.util.Collection;
import java.util.List;

public class BeanCimatec {
    private String nome;
    private List listaNomes;

    public BeanCimatec(){
        this.nome = "";
        this.listaNomes = null;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection getListaNomes(){
        AcessoDAO dao = new AcessoDAO();
        this.listaNomes = (List)dao.recuperaRegistroComParametros(nome);
        return this.listaNomes;
    }
}
