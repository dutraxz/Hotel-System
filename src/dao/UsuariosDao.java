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
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario " + erro);
            return false;
        }
    }
}
