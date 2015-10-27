package interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Walter Gandarella
 */
public interface IF_DAO {
    public boolean adicionar(Object obj) throws SQLException, ClassNotFoundException;
    public boolean alterar(Object obj) throws SQLException, ClassNotFoundException;
    public boolean excluir(Object obj) throws SQLException, ClassNotFoundException;
    public Object getPorId(Object obj) throws SQLException, ClassNotFoundException;
    public List getTodos() throws SQLException, ClassNotFoundException;
}
