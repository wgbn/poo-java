import java.util.HashMap;

/**
 * Created by walter on 02/06/15.
 */
public class AlbumUsuario {

    private HashMap listaPagina = new HashMap();

    public void criaAlbumUsuario(){
        for (int i = 1; i <= 4; i++){
            Pagina p = new Pagina();
            p.setPagina(new Integer(i));
            this.listaPagina.put(p.getPagina(), p);
        }
    }

    public HashMap getListaPagina() {
        return listaPagina;
    }

    public void setListaPagina(HashMap _listaPagina) {
        this.listaPagina = _listaPagina;
    }
}
