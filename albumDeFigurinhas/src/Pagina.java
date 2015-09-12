import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by walter on 02/06/15.
 */
public class Pagina {

    Integer pagina;
    ArrayList listaFigurinhas = new ArrayList();

    public Integer getPagina() {
        return pagina;
    }

    public ArrayList getListaFigurinhas() {
        return listaFigurinhas;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public boolean colaFigurinha(Figurinha _f){
        if (this.pagina.intValue() == _f.getTime()){
            if (!this.listaFigurinhas.contains(_f))
                this.listaFigurinhas.add(_f);
        }

        return false;
    }

}
