package entity;

import javax.persistence.*;

@Entity
@Table(name="pessoas")
public class PessoaEntity {
    private Long id;
    private String nome;
    private Integer idade;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pessoas_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="pessoas_nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name="pessoas_idade")
    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}