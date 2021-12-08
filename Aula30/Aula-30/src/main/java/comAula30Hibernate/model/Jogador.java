package comAula30Hibernate.model;

import javax.persistence.*;

@Entity
@Table
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String posicao;
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "treinador_id")
    private Treinador treinador;


    public Jogador() {
    }

    public Jogador(String nome, String posicao, String numero, Equipe equipe, Treinador treinador) {
        this.nome = nome;
        this.posicao = posicao;
        this.numero = numero;
        this.equipe = equipe;
        this.treinador = treinador;
    }

    public Jogador(Long id, String nome, String posicao, String numero, Equipe equipe, Treinador treinador) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.numero = numero;
        this.equipe = equipe;
        this.treinador = treinador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }
}
