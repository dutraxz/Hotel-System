package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public class Conexao {
        private String driver = "com.mysql.jdbc.Driver";
        private String url = "jdbc:mysql://127.0.0.1:3306/apphotelaria";
        private String usuario = "dbaHotel";
        private String senha = "dbaHotel123";

        public Connection conectar() {
            Connection condb = null;

            try {
                //Especifica a rota do driver a ser carregado (JBDC para SGBD MySQL)
                Class.forName(driver);

                //Inicializar o driver ja carregado meio ao meio do metodoo getConnection(IP, nome do banco, usuario, senha)
                condb = DriverManager.getConnection(url, usuario, senha);
                return condb;
            } catch (SQLException erro) {
                System.out.println("Erro ao conectar ao Banco de Dados" + erro);
                return null;
            }
        }