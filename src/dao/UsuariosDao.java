package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDao {
    //Conexão para instânciar classe para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario(/*Usuario usuario*/){

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoUsuario = condb.prepareStatement("INSERT INTO usuarios " + " (nome, email, senha) VALUES (?, ?, md5(?));");

            //Setar os parametros
            novoUsuario.setString(1, "Victor Dias");
            novoUsuario.setString(2, "victor.dias@gmail.com");
            novoUsuario.setString(3, "007");


            int linhaAfetada = novoUsuario.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario " + erro);
            return false;
        }
    }
    public boolean deleteUsuario() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerUsuario = condb.prepareStatement
                    ("DELETE adicionais WHERE id = ?; ");
            removerUsuario.setInt(1, 1);

            int linhaAfetada = removerUsuario.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Usuário!" + erro);
            return false;
        }
    }
}
