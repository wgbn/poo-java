package entity;

import javax.persistence.*;

/**
 * Created by walter on 10/10/15.
 */
@Entity
@Table(name = "telefone", schema = "", catalog = "acoesdb")
public class TelefoneEntity {
    private int id;
    private String numero;
    private ClienteEntity clienteByClienteId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "numero")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TelefoneEntity that = (TelefoneEntity) o;

        if (id != that.id) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    public ClienteEntity getClienteByClienteId() {
        return clienteByClienteId;
    }

    public void setClienteByClienteId(ClienteEntity clienteByClienteId) {
        this.clienteByClienteId = clienteByClienteId;
    }
}
