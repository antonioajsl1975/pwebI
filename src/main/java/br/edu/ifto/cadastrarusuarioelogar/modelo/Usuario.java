package br.edu.ifto.cadastrarusuarioelogar.modelo;

import java.util.List;
import java.util.Objects;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
//    private boolean isSdmin;

    private List<Telefone> telefones;

    public Usuario(){

    }

    public Usuario(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
//        this.isSdmin = isSdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public boolean isSdmin() {
//        return isSdmin;
//    }
//
//    public void setSdmin(boolean sdmin) {
//        isSdmin = sdmin;
//    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
//                ", isSdmin=" + isSdmin +
                ", telefones=" + telefones +
                '}';
    }
}
