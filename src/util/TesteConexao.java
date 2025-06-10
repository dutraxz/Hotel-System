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

                //----- TESTE DE INSERT NO BANCO DE DADOS ------

//                ClientesDao clienDAO = new ClientesDao();
//                clienDAO.inserirClientes();
//                System.out.println("Clientes Inserido com suceeso!");

//                PermissaoDao permDAO = new PermissaoDao();
//                permDAO.inserirPermissoes();
//                System.out.println("Permissões Inserido com suceeso!");

//                QuartosDao quarDAO = new QuartosDao();
//                quarDAO.inserirQuartos();
//                System.out.println("Quartos Inserido com suceeso!");

//                AdicionaisDao addDAO = new AdicionaisDao();
//                addDAO.inserirAdicionais();
//                System.out.println("Adicionais Inserido com suceeso!");

//                UsuariosDao usuaDAO = new UsuariosDao();
//                usuaDAO.inserirUsuario();
//                System.out.println("Usuários Inserido com suceeso!");

//                PedidosDao pediDAO = new PedidosDao();
//                pediDAO.inserirPedidos();
//                System.out.println("Pedidos Inserido com suceeso!");

//                ReservasDao reserDAO = new ReservasDao();
//                reserDAO.inserirReservas();
//                System.out.println("Reservas Inserido com suceeso!");

                //----- TESTE DE DELETE NO BANCO DE DADOS ------



                //----- TESTE DE UPDATE NO BANCO DE DADOS ------

                AdicionaisDao attDAO = new AdicionaisDao();
                attDAO.atualizarAdicionais();
                System.out.println("Adicionais Atualizados  com suceeso!");




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
