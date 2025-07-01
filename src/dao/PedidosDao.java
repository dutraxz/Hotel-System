package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDao {
    private Conexao conexao = new Conexao();
    //Conexão para instanciar classe e requisitar acesso ao banco de dados

    //QUERRY INSERT - Inserção
    public boolean inserirPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoPedido = condb.prepareStatement("INSERT INTO pedidos" + "(id_usuario_fk, id_cliente_fk, pagamento) VALUES (?, ?, ?) ;");

            //Setar os parametros
            novoPedido.setInt(1, 11);
            novoPedido.setInt(2, 5);
            novoPedido.setString(3, "Pix");

            int linhaAfetada = novoPedido.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Pedido " + erro);
            return false;
        }
    }

    //QUERRY DELETE - Deletar
    public boolean deletarPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerPedidos = condb.prepareStatement("DELETE FROM pedidos WHERE id = ? ;");

            removerPedidos.setInt(1, 1);

            int linhaAfetada = removerPedidos.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar Pedido " + erro);
            return false;
        }
    }

    //QUEERY UPDATE - Atualizar
    public boolean atualizarPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement alterarPedido = condb.prepareStatement
                    ("UPDATE pedidos " + "SET id_usuario_fk = ? , id_cliente_fk = ? , pagamento = ? " + "WHERE id = ? ;");

            alterarPedido.setInt(1, 11);
            alterarPedido.setInt(2, 5);
            alterarPedido.setString(3, "Credito");
            alterarPedido.setInt(4, 2);

            int linhaAfetada = alterarPedido.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar Pedido " + erro);
            return false;
        }
    }

    public void pesquisarPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement pesquisaPedido = condb.prepareStatement("SELECT id_usuario_fk, id_cliente_fk, pagamento " + "FROM pedidos WHERE id = ? ;");

            pesquisaPedido.setInt(1, 1);
            ResultSet resultado = pesquisaPedido.executeQuery();
            while (resultado.next()) {
                String id_usuario_fk = resultado.getString("id_usuario_fk");
                String id_cliente_fk = resultado.getString("id_cliente_fk");
                String pagamento = resultado.getString("pagamento");

                System.out.println(id_usuario_fk + "id_usuario_fk" + id_cliente_fk + "id_cliente_fk" + pagamento + "pagamento");
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar Pedidos!" + erro);
        }
    }
}

