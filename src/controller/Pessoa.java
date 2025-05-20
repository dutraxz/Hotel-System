package controller;

public class Pessoa {
    private String nome, email, senha;
    private int id;

    /*Contrutor: inicializa a classe
     quando um acesso e tipagem*/
    public Pessoa(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
    public String getemail() {
        return email;
    }

    public String getNomePessoa() {
        return nome;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setNome(String nomePessoa) {
        this.nome = nomePessoa;
    }
}
