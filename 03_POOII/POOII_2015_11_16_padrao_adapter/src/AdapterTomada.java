/**
 * Created by walter on 16/11/15.
 */
public class AdapterTomada extends TomadaDeDoisPinos {

    private TomadaDeTresPinos trespinos;

    public AdapterTomada(TomadaDeTresPinos trespinos) {
        this.trespinos = trespinos;
    }

    @Override
    public void ligarNaTomadaDeDoisPinos(){
        //Varias codificações
        trespinos.ligarNaTomadaDeTresPinos();
    }

}
