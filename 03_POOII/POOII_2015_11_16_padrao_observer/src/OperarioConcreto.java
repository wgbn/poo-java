/**
 * Created by walter on 16/11/15.
 */
public class OperarioConcreto implements Operario {

    private SireneConcreta objetoObservado;

    public OperarioConcreto(SireneConcreta o){
        this.objetoObservado = o;
        this.objetoObservado.addObservador(this);
    }

    @Override
    public void atualizar(Sirene s) {
        if (s == this.objetoObservado)
            System.err.println("[INFORMAÇÂO] A sirene mudou seu estado para "+this.objetoObservado.isAlertaSonoro());
    }
}
