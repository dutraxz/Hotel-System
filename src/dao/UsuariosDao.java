package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDao {
    //Conexão para instânciar classe para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario(/*Usuario usuario*/) {

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
        } catch (Exception erro) {
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
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Usuário!" + erro);
            return false;
        }
    }

    //QUEERY UPDATE - Atualizar
    public boolean atualizarUsuarios() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement alterarUsuario = condb.prepareStatement
                    ("UPDATE usuario " + "SET nome = ?, email = ?, senha = md5 " + "WHERE id = ? ;");

            alterarUsuario.setString(1, "Eduardo");
            alterarUsuario.setString(2, "Edu1503@hotmail.com");
            alterarUsuario.setString(3, "2457");

            int linhaAfetada = alterarUsuario.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar Usuario " + erro);
            return false;
        }
    }

    public void pesquisarUsuarios() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement pesquisaUsuario = condb.prepareStatement
                    ("SELECT nome, email, senha " + "FROM usuarios WHERE id_perm_fk = ?; ");

            pesquisaUsuario.setInt(1, 1);
            ResultSet resultado = pesquisaUsuario.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");
                System.out.println(nome + "nome" + email + "email" + senha + "senha");
            }
            condb.close();
        }
        catch (Exception erro) {
    System.out.println("Erro ao consultar Usuario " + erro);
        }
    }
}