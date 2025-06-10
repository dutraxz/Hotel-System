package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDao {
    //Conexão para instânciar classe para requisitar acesso ao banco de dados
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos(/*Quartos quartos*/){

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos " + " (nome, numero, camaSolteiro, camaCasal, " +
                    "disponivel, preco)  VALUES (?, ?, ?, ?, ?, ?);");
            //Setar os parametros
            novoQuarto.setString(1, "Victor");
            novoQuarto.setString(2, "2457");
            novoQuarto.setInt(3, 30);
            novoQuarto.setInt(4, 20);
            novoQuarto.setBoolean(5, true);
            novoQuarto.setDouble(6, 300.00);

            int linhaAfetada = novoQuarto.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
            catch (Exception erro){
                System.out.println("Erro ao inserir quartos" + erro);
                return false;
        }
    }
    public boolean deleteQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerQuarto = condb.prepareStatement
                    ("DELETE adicionais WHERE id = ?; ");

            removerQuarto.setInt(1, 1);

            int linhaAfetada = removerQuarto.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Quarto!" + erro);
            return false;
        }
    }
}