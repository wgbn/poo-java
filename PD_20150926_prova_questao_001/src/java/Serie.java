import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "serieBean")
@SessionScoped
public class Serie {
    
    private int numero;
    
    public Serie(){
        
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void gerarSerie() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("serie.jsp");
    }
    
}
