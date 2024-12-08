/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitpower.controller;

import fitpower.dao.Conexion;
import fitpower.dao.UserJpaController;
import fitpower.model.User;

/**
 * Controlador de Login de Usuario
 *
 */
public class LoginController {

    //DAO
    private final UserJpaController userDAO;

    //Model
    private static User verifyUser = null;

    public LoginController() {
        //Inicializacion de DAO
        this.userDAO = new UserJpaController(Conexion.getEmf());

    }

    /**
     * Creacion Singleton Usuario Logeado
     */
    private synchronized static void createInstanceUsuario() {
        if (verifyUser == null) {
            verifyUser = new User();
        }
    }

    /**
     * Devuele la instancia unica del usuario logeado
     *
     * @return
     */
    public static User getInstanceUsuario() {
        createInstanceUsuario();
        return verifyUser;
    }

    /**
     * Recibe un usuario desde la vista Si el usuario y el password concuerdan,
     * crea instancia unica de usuario proveniente de la base de datos y
     * devuelve verdadero Si el usuario no concuerda devuelve falso
     *
     * @param unUsuario
     * @return
     */
    public boolean startSession(User unUsuario) {
        boolean estado = false;
        verifyUser = userDAO.startSession(unUsuario);
        if (verifyUser != null) {

        }
        return estado;
    }

}
