package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDao {
    private Conexao conexao = new Conexao();
    //Conexão para instânciar classe para requisitar acesso ao banco de dados

    public boolean inserirAdicionais(/*Adicionais adcionais*/) {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoAdicional = condb.prepareStatement("INSERT INTO adicionais " + " (nome, preco) " +
                    "VALUES (?, ?) ;");

            //Setar os parametros
            novoAdicional.setString(1, "Frigobar com bebidas");
            novoAdicional.setDouble(2, 100.00);

            int linhaAfetada = novoAdicional.executeUpdate();
            condb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Adicional!" + erro);
            return false;
        }
    }

    public boolean deleteAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerAdicional = condb.prepareStatement
                    ("DELETE FROM adicionais WHERE id = ? ;");

            removerAdicional.setInt(1, 1);

            int linhaAfetada = removerAdicional.executeUpdate();
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
            PreparedStatement alterarAdicional = condb.prepareStatement
                    ("UPDATE adicionais " + "SET nome = ?, preco = ? " + "WHERE id = ? ;");

            alterarAdicional.setString(1, "Choc Amargo");
            alterarAdicional.setDouble(2, 50.00);
            alterarAdicional.setInt(3, 4);

            int linhaAfetada = alterarAdicional.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar Adicional!" + erro);
            return false;
        }
    }

    public void pesquisarAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement pesquisaAdicional = condb.prepareStatement("SELECT nome, preco " + "FROM adicionais WHERE id = ? ;");

            pesquisaAdicional.setInt(1, 1);
            ResultSet resultado = pesquisaAdicional.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String preco = resultado.getString("preco");
                System.out.println(nome + "nome" + preco + "preco");
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar Adicional!" + erro);
        }
    }
}