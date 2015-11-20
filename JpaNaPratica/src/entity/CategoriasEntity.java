package entity;

import javax.persistence.*;

/**
 * Created by vivasalute on 20/11/15.
 */
@Entity
@Table(name = "categorias", schema = "", catalog = "jpapratica")
public class CategoriasEntity {
    private int id;
    private String categoria;
    private String descricao;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "categoria", nullable = true, insertable = true, updatable = true, length = 100)
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Basic
    @Column(name = "descricao", nullable = true, insertable = true, updatable = true, length = 300)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriasEntity that = (CategoriasEntity) o;

        if (id != that.id) return false;
        if (categoria != null ? !categoria.equals(that.categoria) : that.categoria != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
