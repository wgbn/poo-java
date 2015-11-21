import br.com.wgbn.sgap.controller.Teste;
import br.com.wgbn.sgap.entity.UsuarioEntity;

import java.util.List;

/**
 * Created by vivasalute on 20/11/15.
 */
public class Main {

    public static void main(String[] args) {
        Teste uf = new Teste();

        List<UsuarioEntity> users = uf.getUsuarios();

        System.out.println("Fazendo loop....");

        for(UsuarioEntity usr : users){
            System.out.println(usr.getNome());
        }
    }

}
