package fitpower.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import fitpower.dao.Conexion;
import fitpower.view.JFrameLogin;

/**
 *
 * @author Ismael
 */
public class Main {

    public static void main(String[] args) {
        new Conexion();
        JFrameLogin vista = new JFrameLogin();
        vista.arranca();
    }
}
