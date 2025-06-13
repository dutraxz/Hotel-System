package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDao {
    //Conexão para instânciar classe para requisitar acesso ao banco de dados
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos(/*Quartos quartos*/) {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos " + " (nome, numero, camaSolteiro, camaCasal, " +
                    "disponivel, preco)  VALUES (?, ?, ?, ?, ?, ?);");
            //Setar os parametros
            novoQuarto.setString(1, "Victor");
            novoQuarto.setString(2, "2457");
            novoQuarto.setInt(3, 30);
            novoQuarto.setInt(4, 20);
            novoQuarto.setBoolean(5, true);
            novoQuarto.setDouble(6, 300.00);

            int linhaAfetada = novoQuarto.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quartos" + erro);
            return false;
        }
    }

    public boolean deleteQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerQuarto = condb.prepareStatement
                    ("DELETE adicionais WHERE id = ?; ");

            removerQuarto.setInt(1, 1);

            int linhaAfetada = removerQuarto.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Quarto!" + erro);
            return false;
        }
    }

    //QUEERY UPDATE - Atualizar
    public boolean atualizarQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement alterarQuarto = condb.prepareStatement
                    ("UPDATE pedidos " + "SET nome = ?, numero = ?, camaSolteiro = ?, camaCasal = ?, disponivel = ?, preco = ?" + "WHERE id = ?;");

            alterarQuarto.setString(1, "Quarto de Luxo 00");
            alterarQuarto.setString(2, "100");
            alterarQuarto.setInt(3, 2);
            alterarQuarto.setInt(4, 4);
            alterarQuarto.setBoolean(5, false);
            alterarQuarto.setDouble(6, 800.00);

            int linhaAfetada = alterarQuarto.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar Quarto " + erro);
            return false;
        }
    }

    public void pesquisarQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement pesquisaQuarto = condb.prepareStatement("SELECT nome, numero, camaSolteiro, camaCasal, disponivel, preco " + "FROM quartos WHERE id = ?; ");

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
