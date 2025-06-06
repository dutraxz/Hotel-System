package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDao {
    private Conexao conexao = new Conexao();
    //Conexão para instânciar classe para requisitar acesso ao banco de dados

    public boolean inserirAdicionais(/*Adicionais adcionais*/) {

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoAdicionais = condb.prepareStatement("INSERT INTO adicionais " + " (nome, preco) " +
                    "VALUES (?, ?);");

            //Setar os parametros
            novoAdicionais.setString(1, "Frigobar com bebidas");
            novoAdicionais.setDouble(2, 100.00);

            int linhaAfetada = novoAdicionais.executeUpdate();
            return linhaAfetada > 0;

        }
            catch (Exception erro) {
                System.out.println("Erro ao inserir adicionais!" + erro);
                return false;
        }
    }
}
