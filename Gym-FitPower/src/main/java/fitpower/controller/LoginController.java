/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitpower.controller;

import fitpower.dao.Conexion;
import fitpower.dao.UserJpaController;
import fitpower.model.Users;

/**
 * Controlador de Login de Usuario
 *
 */
public class LoginController {

    //DAO
    private final UserJpaController userDAO;

    //Model
    private static Users verifyUser = null;

    public LoginController() {
        //Inicializacion de DAO
        this.userDAO = new UserJpaController(Conexion.getEmf());

    }

    /**
     * Creacion Singleton Usuario Logeado
     */
    private synchronized static void createInstanceUsuario() {
        if (verifyUser == null) {
            verifyUser = new Users();
        }
    }

    /**
     * Devuele la instancia unica del usuario logeado
     *
     * @return
     */
    public static Users getInstanceUsuario() {
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
    public boolean startSession(Users unUsuario) {
        boolean estado = false;
        System.out.println("Iniciando sesión para el usuario: " + unUsuario.getUsername());
        
        // Llamada al método DAO
        verifyUser = userDAO.startSession(unUsuario);

        if (verifyUser != null) {
            System.out.println("Inicio de sesión exitoso. Usuario encontrado: " + verifyUser.getUsername());
            estado = true;
        } else {
            System.out.println("Error: Usuario o contraseña incorrectos.");
        }

        return estado;
    }

}
