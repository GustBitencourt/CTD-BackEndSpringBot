package com.Aula29SpringDataHibernate.mesa;

import javax.persistence.*;

@Entity
@Table
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String posicao;
    private int numero;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "clube_id")
    private Clube clube;

    public Jogador() {
    }

    public Jogador(String nome, String posicao, int numero, Clube clube) {
        this.nome = nome;
        this.posicao = posicao;
        this.numero = numero;
        this.clube = clube;
    }

    public Jogador(Long id, String nome, String posicao, int numero, Clube clube) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.numero = numero;
        this.clube = clube;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", posicao='" + posicao + '\'' +
                ", numero=" + numero +
                ", clube=" + clube +
                '}';
    }
}
