package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientesDao {
    //Conexão para instânciar classe para requisitar acesso ao Banco de Dados
    private Conexao conexao = new Conexao();

    public boolean inserirClientes(/*Clientes clients*/) {

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCliente = condb.prepareStatement("INSERT INTO clientes " + "(nome, email, cpf, telefone)" +
                    "VALUES (?, ?, ?, ?) ;");

            //Setar os parametros
            novoCliente.setString(1, "Victor");
            novoCliente.setString(2, "victor.dutra@gmail.com");
            novoCliente.setString(3, "123.123.123-00");
            novoCliente.setString(4, "(15) 99000-1111");

            int linhaAfetada = novoCliente.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario" + erro);
            return false;
        }
    }

    public boolean deleteClientes() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerCliente = condb.prepareStatement
                    ("DELETE FROM clientes WHERE id = ? ;");

            removerCliente.setInt(1, 1);

            int linhaAfetada = removerCliente.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Cliente!" + erro);
            return false;
        }
    }

    public boolean atualizarClientes() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement alterarCliente = condb.prepareStatement
                    ("UPDATE clientes " + "SET nome = ?, email = ?, cpf = ?, telefone = ? " + "WHERE id = ? ;");

            alterarCliente.setString(1, "Desenvolvedor");
            alterarCliente.setString(2, "dev.backend@gmail.com");
            alterarCliente.setString(3, "123.123.123-00");
            alterarCliente.setString(4, "(15) 99000-0011");
            alterarCliente.setInt(5, 5);

            int linhaAfetada = alterarCliente.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar Cliente" + erro);
            return false;
        }
    }

    public void pesquisarQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement pesquisaQuarto = condb.prepareStatement("SELECT nome, numero, camaSolteiro, camaCasal, disponivel, preco " + "FROM quartos WHERE id = ? ;");

            pesquisaQuarto.setInt(1, 1);
            ResultSet resultado = pesquisaQuarto.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                String camaSolteiro = resultado.getString("camaSolteiro");
                String camaCasal = resultado.getString("camaCasal");
                String disponivel = resultado.getString("disponivel");
                String preco = resultado.getString("preco");

                System.out.println(nome + "nome" + numero + "numero" + camaSolteiro + "camaSolteiro" + camaCasal + "camaCasal" + disponivel + "disponivel" + preco + "preco");
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar Quartos!" + erro);
        }
    }
}

