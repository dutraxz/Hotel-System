package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDao {
    //Conexão para instânciar classe para requisitar acesso ao Banco de Dados
    private Conexao conexao = new Conexao();

    public boolean inserirClientes(/*Clientes clients*/) {

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCliente = condb.prepareStatement("INSERT INTO clientes " + " (nome, email, cpf, telefone) " +
                    "VALUES (?, ?, ?, ?);");

            //Setar os parametros
            novoCliente.setString(1, "Victor");
            novoCliente.setString(2, "victor.dutra@gmail.com");
            novoCliente.setString(3, "123.123.123-00");
            novoCliente.setString(4, "(15) 99000-1111");

            int linhaAfetada = novoCliente.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario" + erro);
            return false;
        }
    }
    public boolean deleteCliente    () {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerClientes = condb.prepareStatement
                    ("DELETE adicionais WHERE id = ?; ");

            removerClientes.setInt(1, 1);

            int linhaAfetada = removerClientes.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Cliente!" + erro);
            return false;
        }
    }
}

