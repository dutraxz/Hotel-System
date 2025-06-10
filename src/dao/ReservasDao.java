package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
