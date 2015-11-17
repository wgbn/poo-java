import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by walter on 16/11/15.
 */
public class SireneConcreta implements Sirene {
    private boolean alertaSonoro = false;
    private ArrayList observadores = new ArrayList();

    public SireneConcreta(){}

    public void alterarAlerta(){
        this.alertaSonoro = !this.alertaSonoro;
        this.notificaTodosObservadores();
    }

    public void notificaTodosObservadores(){
        Iterator i = this.observadores.iterator();
        while (i.hasNext()){
            Operario o = (Operario)i.next();
            o.atualizar(this);
        }
    }

    public boolean isAlertaSonoro() {
        return alertaSonoro;
    }

    @Override
    public void addObservador(Operario o) {
        this.observadores.add(o);
    }

    @Override
    public void remObservador(Operario o) {
        this.observadores.remove(o);
    }
}
