package model;

public class Cliente extends Pessoa {
    //Declaracao de uma variavel propria da class Cliente
    private int id;
    private String cpf, telefone, nome, email;


    public Cliente(String email, String nome, String senha, String cpf, String telefone) {
        super(email, nome, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
    }

    //getters and setters


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

