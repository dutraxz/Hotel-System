package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDao {
    private Conexao conexao = new Conexao();
    //Conexão para instânciar classe para requisitar acesso ao banco de dados

    public boolean inserirAdicionais(/*Adicionais adcionais*/) {

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoAdicionais = condb.prepareStatement("INSERT INTO adicionais " + " (nome, preco) " +
                    "VALUES (?, ?);");

            //Setar os parametros
            novoAdicionais.setString(1, "Frigobar com bebidas");
            novoAdicionais.setDouble(2, 100.00);

            int linhaAfetada = novoAdicionais.executeUpdate();
            condb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicionais!" + erro);
            return false;
        }
    }
    public boolean deleteAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerAdicionais = condb.prepareStatement
                    ("DELETE adicionais WHERE id = ?; ");

            removerAdicionais.setInt(1, 1);

            int linhaAfetada = removerAdicionais.executeUpdate();
            condb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar Adicional!" + erro);
            return false;
        }
    }
    public boolean atualizarAdicionais() {

        try {
        Connection condb = conexao.conectar();
        PreparedStatement alteradoAdicionais = condb.prepareStatement
                ("UPDATE adicionais " + "SET nome = ?, preco = ? " + "WHERE id = ?; ");

        alteradoAdicionais.setString(1, "Chocolate");
            alteradoAdicionais.setDouble(2, 50.00);
            alteradoAdicionais.setInt(3, 1);

        int linhaAfetada = alteradoAdicionais.executeUpdate();
            condb.close();
        return linhaAfetada > 0;
    }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar adicionais!" + erro);
            return false;
        }
    }
}
