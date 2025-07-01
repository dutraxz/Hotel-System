package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PermissaoDao {
    private Conexao conexao = new Conexao();

    public boolean inserirPermissoes(/*PermissaoDao permissao*/) {

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoPermissao = condb.prepareStatement("INSERT INTO permissao " + "(nome) VALUES (?) ;");

            //Setar os parametros
            novoPermissao.setString(1, "Cargo");

            int linhaAfetada = novoPermissao.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Permissao: " + erro);
            return false;
        }
    }

    public boolean deletePermissao() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerPermissao = condb.prepareStatement
                    ("DELETE FROM permissao WHERE id = ? ;");

            removerPermissao.setInt(1, 1);

            int linhaAfetada = removerPermissao.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Permissao! " + erro);
            return false;
        }
    }

    public boolean atualizarPermissao() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement alterarPermissao = condb.prepareStatement
                    ("UPDATE permissao " + " SET nome = ?" + " WHERE id = ? ;");
            alterarPermissao.setString(1, "Suporte TI");
            alterarPermissao.setInt(2, 4);
            int linhaAfetada = alterarPermissao.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar Permissao " + erro);
            return false;
        }
    }

    public void pesquisarPermissao() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement pesquisaPermissao = condb.prepareStatement("SELECT nome " + "FROM permissao WHERE id = ? ");

            pesquisaPermissao.setInt(1, 1);
            ResultSet resultado = pesquisaPermissao.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                System.out.println(nome + "nome");
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar Permissao!" + erro);
        }
    }
}
