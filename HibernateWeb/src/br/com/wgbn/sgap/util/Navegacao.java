package br.com.wgbn.sgap.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Walter Gandarella
 */
public class Navegacao {
    public static final void navegarPara(String _pagina){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/paginas/" + _pagina);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
