package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidosDao {
    private Conexao conexao = new Conexao();
    //Conexão para instanciar classe e requisitar acesso ao banco de dados

    public boolean inserirPedidos() {

        try {

            Connection condb = conexao.conectar();
            PreparedStatement novoPedido = condb.prepareStatement("INSERT INTO pedidos" + "(id_usuario_fk, id_cliente_fk, pagamento) VALUES (?, ?, ?);");

            //Setar os parametros
            novoPedido.setInt(1, 4);
            novoPedido.setInt(2, 1);
            novoPedido.setString(3, "Pix");

            int linhaAfetada = novoPedido.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir Pedido " + erro);
            return false;
        }
    }

    public boolean deletarPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerPedidos = condb.prepareStatement("DELETE pedidos WHERE id = ?; ");

            removerPedidos.setInt(1, 1);

            int linhaAfetada = removerPedidos.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar Pedido " + erro);
            return false;
        }
    }
}