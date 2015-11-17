/**
 * Created by walter on 16/11/15.
 */
public class ManagerBridge {
    private DataAccess acesso;

    public ManagerBridge(){}

    public void setAcesso(DataAccess _acesso) {
        this.acesso = _acesso;
    }

    public void inserir(String _nome){
        this.acesso.criar(_nome);
    }

    public String imprimir(){
        return this.acesso.imprimir();
    }
}
