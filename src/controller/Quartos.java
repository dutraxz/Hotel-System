package controller;

public class Quartos {
    private int id, preco, qtd_cama_casal, qtd_cama_solteiro;
    private String nome, numero;
    private boolean disponivel;

    public Quartos(String nome, String numero, int preco, int qtd_cama_casal, int qtd_cama_solteiro, boolean disponivel) {
        this.nome = nome;
        this.numero = numero;
        this.preco = preco;
        this.qtd_cama_casal = qtd_cama_casal;
        this.qtd_cama_solteiro = qtd_cama_solteiro;
        this.disponivel = disponivel;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getQtd_cama_casal() {
        return qtd_cama_casal;
    }

    public void setQtd_cama_casal(int qtd_cama_casal) {
        this.qtd_cama_casal = qtd_cama_casal;
    }

    public int getQtd_cama_solteiro() {
        return qtd_cama_solteiro;
    }

    public void setQtd_cama_solteiro(int qtd_cama_solteiro) {
        this.qtd_cama_solteiro = qtd_cama_solteiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
