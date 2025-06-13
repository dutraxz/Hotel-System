package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservasDao {
    private Conexao conexao = new Conexao();
    //Conexão para intanciar a classe e requisitar acesso ao banco de dados


    public boolean inserirReservas() {

        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoReserva = condb.prepareStatement("INSERT INTO reservas" + "(id_adicional_fk, id_quarto_fk, id_pedido_fk) VALUES (?, ?, ?);");

            novoReserva.setInt(1, 1);
            novoReserva.setInt(2, 3);
            novoReserva.setInt(3, 1);

            int linhaAfetada = novoReserva.executeUpdate();
            condb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Reserva: " + erro);
            return false;
        }
    }

    public boolean deleteReserva() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerReserva = condb.prepareStatement
                    ("DELETE reservas WHERE id = ?; ");

            removerReserva.setInt(1, 1);

            int linhaAfetada = removerReserva.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Reserva! " + erro);
            return false;
        }
    }

    public boolean atualizarReservas() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement alterarReserva = condb.prepareStatement
                    ("UPDATE reserva " + "SET = id_adicional_fk = ?, id_quarto_fk = ?, id_pedido_fk = ? WHERE id = ? ;");

            alterarReserva.setInt(1, 1);
            alterarReserva.setInt(1, 3);
            alterarReserva.setInt(1, 1);


            int linhhaAfetada = alterarReserva.executeUpdate();
            condb.close();
            return linhhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao atualizar Reserva " + erro);
            return false;
        }
    }
    public void pesquisarReservas() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement pesquisaReserva = condb.prepareStatement("SELECT id_adicional_fk, id_quarto_fk, id_pedido_fk   " + "FROM reservas WHERE id = ?; ");

            pesquisaReserva.setInt(1, 1);
            ResultSet resultado = pesquisaReserva.executeQuery();

            while (resultado.next()) {
                String id_adicional_fk = resultado.getString("id_adicional_fk");
                String id_quarto_fk = resultado.getString("id_quarto_fk");
                String id_pedido_fk = resultado.getString("id_pedido_fk");

                System.out.println(id_adicional_fk + "id_adicional_fk" + id_quarto_fk + "id_quarto_fk" + id_pedido_fk + "id_pedido_fk");
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar Reservas!" + erro);
        }
    }
}
