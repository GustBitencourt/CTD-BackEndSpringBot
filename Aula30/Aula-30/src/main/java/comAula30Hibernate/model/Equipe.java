package comAula30Hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cidade;

    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private Set<Jogador> jogadores = new HashSet<>();

    public Equipe() {
    }

    public Equipe(String nome, String cidade, Set<Jogador> jogadores) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = jogadores;
    }

    public Equipe(Integer id, String nome, String cidade, Set<Jogador> jogadores) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = jogadores;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
