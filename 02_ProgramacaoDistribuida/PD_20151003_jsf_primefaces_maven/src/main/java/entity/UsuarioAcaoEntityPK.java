package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by walter on 10/10/15.
 */
public class UsuarioAcaoEntityPK implements Serializable {
    private int usuarioId;
    private int acaoId;

    @Column(name = "usuario_id")
    @Id
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Column(name = "acao_id")
    @Id
    public int getAcaoId() {
        return acaoId;
    }

    public void setAcaoId(int acaoId) {
        this.acaoId = acaoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioAcaoEntityPK that = (UsuarioAcaoEntityPK) o;

        if (usuarioId != that.usuarioId) return false;
        if (acaoId != that.acaoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usuarioId;
        result = 31 * result + acaoId;
        return result;
    }
}
