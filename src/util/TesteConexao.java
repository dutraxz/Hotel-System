package util;

import controller.UsuariosController;
import dao.*;
import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        UsuariosController usuariosController = new UsuariosController();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {

                //Testando a autenticvação d eum usuário

                //----- TESTE DE INSERT NO BANCO DE DADOS ------

//                ClientesDao clienDAO = new ClientesDao();
//                clienDAO.inserirClientes();
//                System.out.println("Cliente Inserido com suceeso!");

//                PermissaoDao permDAO = new PermissaoDao();
//                permDAO.inserirPermissoes();
//                System.out.println("Permissão Inserido com suceeso!");

//                QuartosDao quarDAO = new QuartosDao();
//                quarDAO.inserirQuartos();
//                System.out.println("Quartos Inserido com suceeso!");

//                AdicionaisDao addDAO = new AdicionaisDao();
//                addDAO.inserirAdicionais();
//                System.out.println("Adicionai Inserido com suceeso!");

//                UsuariosDao usuaDAO = new UsuariosDao();
//                usuaDAO.inserirUsuario();
//                System.out.println("Usuário Inserido com suceeso!");

//                PedidosDao pediDAO = new PedidosDao();
//                pediDAO.inserirPedidos();
//                System.out.println("Pedido Inserido com suceeso!");

//                ReservasDao reserDAO = new ReservasDao();
//                reserDAO.inserirReservas();
//                System.out.println("Reserva Inserido com suceeso!");


                //----- TESTE DE DELETE NO BANCO DE DADOS ------

//
//                ClientesDao clienDAO = new ClientesDao();
//                clienDAO.deleteClientes();
//                System.out.println("Cliente Deletado com suceeso!");

//                PermissaoDao permDAO = new PermissaoDao();
//                permDAO.deletePermissao();
//                System.out.println("Permissão Deletado com suceeso!");
//
//                QuartosDao quarDAO = new QuartosDao();
//                quarDAO.deleteQuarto();
//                System.out.println("Quarto Deletado com suceeso!");
//
//                AdicionaisDao addDAO = new AdicionaisDao();
//                addDAO.deleteAdicionais();
//                System.out.println("Adicional Deletado com suceeso!");

//                UsuariosDao usuaDAO = new UsuariosDao();
//                usuaDAO.deleteUsuario();
//                System.out.println("Usuário Deletado com suceeso!");
//
//                PedidosDao pediDAO = new PedidosDao();
//                pediDAO.deletarPedidos();
//                System.out.println("Pedido Deletado com suceeso!");

//                ReservasDao reserDAO = new ReservasDao();
//                reserDAO.deleteReserva();
//                System.out.println("Reserva Deletado com suceeso!");
//


                //----- TESTE DE UPDATE NO BANCO DE DADOS -----


//                ClientesDao clienDAO = new ClientesDao();
//                clienDAO.atualizarClientes();
//                System.out.println("Cliente Atualizado com suceeso!");
//
//                PermissaoDao permDAO = new PermissaoDao();
//                permDAO.atualizarPermissao();
//                System.out.println("Permissão Atualizado com suceeso!");
//
//                QuartosDao quarDAO = new QuartosDao();
//                quarDAO.atualizarQuartos();
//                System.out.println("Quarto Atualizado com suceeso!");
//
//                AdicionaisDao addDAO = new AdicionaisDao();
//                addDAO.atualizarAdicionais();
//                System.out.println("Adicional Atualizado com suceeso!");
//
//                UsuariosDao usuaDAO = new UsuariosDao();
//                usuaDAO.atualizarUsuario();
//                System.out.println("Usuario Atualizado com suceeso!");

//                PedidosDao pediDAO = new PedidosDao();
//                pediDAO.atualizarPedidos();
//                System.out.println("Pedido Atualizado com suceeso!");
//
//                ReservasDao reserDAO = new ReservasDao();
//                reserDAO.atualizarReservas();
//                System.out.println("Reserva Atualizado com suceeso!");


                //----- TESTE DE CONSULTA NO BANCO DE DADOS ------


//                ClientesDao clienDAO = new ClientesDao();
//                clienDAO.pesquisarQuartos();
//                System.out.println("Cliente Consultado com suceeso!");
//
//                PermissaoDao permDAO = new PermissaoDao();
//                permDAO.pesquisarPermissao();
//                System.out.println("Permissão Consultada com suceeso!");

//                QuartosDao quarDAO = new QuartosDao();
//                quarDAO.pesquisarQuartos();
//                System.out.println("Quarto Consultado com suceeso!");
//
//                AdicionaisDao addDAO = new AdicionaisDao();
//                addDAO.pesquisarAdicionais();
//                System.out.println("Adicional Consultada com suceeso!");
//
//                UsuariosDao usuaDAO = new UsuariosDao();
//                usuaDAO.pesquisarUsuarios();
//                System.out.println("Usuário Consultado com suceeso!");

//                PedidosDao pediDAO = new PedidosDao();
//                pediDAO.pesquisarPedidos();
//                System.out.println("Pedido Consultado com suceeso!");
//
//                ReservasDao reserDAO = new ReservasDao();
//                reserDAO.pesquisarReservas();
//                System.out.println("Reserva Consultada com suceeso!");


                usuariosController.verificarCredenciais("Edu1503@hotmail.com", "2457");
                condb.close();
                System.out.println("Conexão encerrada");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão:" + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
