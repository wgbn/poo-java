/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.mapeamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author André Portugal
 */
@Entity
@Table(name = "aluno")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
//    @NamedQuery(name = "Aluno.findByMatricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula"),
//    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
//    @NamedQuery(name = "Aluno.findByEndereco", query = "SELECT a FROM Aluno a WHERE a.endereco = :endereco"),
//    @NamedQuery(name = "Aluno.findByDatanasc", query = "SELECT a FROM Aluno a WHERE a.datanasc = :datanasc"),
//    @NamedQuery(name = "Aluno.findByValormensal", query = "SELECT a FROM Aluno a WHERE a.valormensal = :valormensal")})
public class Aluno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "matricula")
    private Integer matricula;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "datanasc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanasc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valormensal")
    private BigDecimal valormensal;

    public Aluno() {
    }

    public Aluno(Integer matricula) {
        this.matricula = matricula;
    }

    public Aluno(Integer matricula, String nome, String endereco, Date datanasc, BigDecimal valormensal) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.datanasc = datanasc;
        this.valormensal = valormensal;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public BigDecimal getValormensal() {
        return valormensal;
    }

    public void setValormensal(BigDecimal valormensal) {
        this.valormensal = valormensal;
    }


    @Override
    public String toString() {
        return "br.ba.poo2.mapeamento.Aluno[ matricula=" + matricula + " ]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 17 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 17 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 17 * hash + (this.datanasc != null ? this.datanasc.hashCode() : 0);
        hash = 17 * hash + (this.valormensal != null ? this.valormensal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.matricula != other.matricula && (this.matricula == null || !this.matricula.equals(other.matricula))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.endereco == null) ? (other.endereco != null) : !this.endereco.equals(other.endereco)) {
            return false;
        }
        if (this.datanasc != other.datanasc && (this.datanasc == null || !this.datanasc.equals(other.datanasc))) {
            return false;
        }
        if (this.valormensal != other.valormensal && (this.valormensal == null || !this.valormensal.equals(other.valormensal))) {
            return false;
        }
        return true;
    }

    
    private static final long serialVersionUID = 4719759238076807213L;

    
    
}
