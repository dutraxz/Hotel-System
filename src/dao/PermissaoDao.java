package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PermissaoDao {
    private Conexao conexao = new Conexao();

    public boolean inserirPermissoes(/*PermissaoDao permissao*/) {

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoPermissao = condb.prepareStatement("INSERT INTO permissao" + "(nome) VALUES (?);");

            //Setar os parametros
            novoPermissao.setString(1, "Cargo");

            int linhaAfetada = novoPermissao.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao inserir permissoes: " + erro);
            return false;
        }
    }
    public boolean deletePermissao() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerPermissao = condb.prepareStatement
                    ("DELETE adicionais WHERE id = ?; ");

            removerPermissao.setInt(1, 1);

            int linhaAfetada = removerPermissao.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Permissão!" + erro);
            return false;
        }
    }
}