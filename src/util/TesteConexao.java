package util;

import dao.*;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try{
//                ClientesDao clienDAO = new ClientesDao();
//                clienDAO.inserirClientes();
//                System.out.println("Clientes Inserido com suceeso!");

//                PermissaoDao permDAO = new PermissaoDao();
//                permDAO.inserirPermissoes();
//                System.out.println("Permissões Inserido com suceeso!");
//
//                QuartosDao quarDAO = new QuartosDao();
//                quarDAO.inserirQuartos();
//                System.out.println("Quartos Inserido com suceeso!");
//
//                AdicionaisDao addDAO = new AdicionaisDao();
//                addDAO.inserirAdicionais();
//                System.out.println("Adicionais Inserido com suceeso!");

                UsuariosDao usuaDAO = new UsuariosDao();
                usuaDAO.inserirUsuario();
                System.out.println("Usuários Inserido com suceeso!");
//
                condb.close();
                System.out.println("Conexão encerrada");
            }
            catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão:" + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
