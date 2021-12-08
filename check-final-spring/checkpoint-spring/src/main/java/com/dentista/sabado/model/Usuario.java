package com.dentista.sabado.model;

public class Usuario {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer acesso;

    //Padrão
    public Usuario() {
    }

    //Com Id
    public Usuario(Integer id, String nome, String sobrenome, Integer acesso) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.acesso = acesso;
    }

    //Sem id
    public Usuario(String nome, String sobrenome, Integer acesso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.acesso = acesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getAcesso() {
        return acesso;
    }

    public void setAcesso(Integer acesso) {
        this.acesso = acesso;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", acesso=" + acesso +
                '}';
    }
}
