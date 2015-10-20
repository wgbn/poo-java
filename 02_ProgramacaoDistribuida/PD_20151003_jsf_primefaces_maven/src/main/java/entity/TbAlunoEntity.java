package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by walter on 17/10/15.
 */
@Entity
@Table(name = "TbAluno", schema = "", catalog = "dbpoo2")
public class TbAlunoEntity {
    private int matricula;
    private String nome;
    private String endereco;
    private Timestamp datanasce;
    private BigDecimal valormensal;

    @Id
    @Column(name = "matricula", nullable = false, insertable = true, updatable = true)
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Basic
    @Column(name = "nome", nullable = true, insertable = true, updatable = true, length = 45)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "endereco", nullable = true, insertable = true, updatable = true, length = 150)
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Basic
    @Column(name = "datanasce", nullable = true, insertable = true, updatable = true)
    public Timestamp getDatanasce() {
        return datanasce;
    }

    public void setDatanasce(Timestamp datanasce) {
        this.datanasce = datanasce;
    }

    @Basic
    @Column(name = "valormensal", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getValormensal() {
        return valormensal;
    }

    public void setValormensal(BigDecimal valormensal) {
        this.valormensal = valormensal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbAlunoEntity that = (TbAlunoEntity) o;

        if (matricula != that.matricula) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (endereco != null ? !endereco.equals(that.endereco) : that.endereco != null) return false;
        if (datanasce != null ? !datanasce.equals(that.datanasce) : that.datanasce != null) return false;
        if (valormensal != null ? !valormensal.equals(that.valormensal) : that.valormensal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matricula;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (datanasce != null ? datanasce.hashCode() : 0);
        result = 31 * result + (valormensal != null ? valormensal.hashCode() : 0);
        return result;
    }
}
