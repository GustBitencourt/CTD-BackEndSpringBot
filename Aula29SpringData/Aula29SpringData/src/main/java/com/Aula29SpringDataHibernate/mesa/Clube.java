package com.Aula29SpringDataHibernate.mesa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;
    @OneToMany(mappedBy = "clube", fetch = FetchType.LAZY)
    private Set<Jogador> jogadores = new HashSet<>();

    public Clube() {
    }

    public Clube(String nome, String cidade, Set<Jogador> jogadores) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = jogadores;
    }

    public Clube(Long id, String nome, String cidade, Set<Jogador> jogadores) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = jogadores;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Set<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @Override
    public String toString() {
        return "Clube{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", jogadores=" + jogadores +
                '}';
    }
}
