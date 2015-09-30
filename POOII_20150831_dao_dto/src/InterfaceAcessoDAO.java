import java.util.Collection;

/**
 * Created by walter on 31/08/15.
 */
public interface InterfaceAcessoDAO {
    Collection recuperaRegistroComParametros(String _nome);

    String recuperaRegistroPorPK(int _pk);
}
