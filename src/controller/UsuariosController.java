package controller;

import dao.UsuariosDao;
import model.User;


public class UsuariosController {
    private final UsuariosDao usuariosDao;

    /*onstrutor para inicializar objeto UsuariosController()
    Ao incializá-lo, o construtor de UsuariosDao() será executadoo que significa que a camada de Controller
    estará verificando se os parâmetros necessários foram informados para que sejam enviados às requisições
    (package DAO - Data Acess Object
    */
    public UsuariosController() {
        this.usuariosDao = new UsuariosDao();
    }
    /*Metodo para verificar se os parâmetros necessários para autentucação estão presentes,
    ou seja. nao podem ser vazios ou nulos; se estiverem presentes,um objeto de Usuarios
    é inicializado como uma instancia*/

    public boolean verificarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false; }
        User usuario = new User("", email, senha, 0);
        return usuariosDao.pesquisarUsuarios(usuario);
    }
}
