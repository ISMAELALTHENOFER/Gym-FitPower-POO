/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ismael
 */
public class Conexion {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public Conexion() {
        Conexion.conectar();
    }

    private static void conectar() {
        if (em == null) {
            Conexion.emf = Persistence.createEntityManagerFactory("fitpower_Gym");
            Conexion.em = Conexion.emf.createEntityManager();
        }
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        Conexion.emf = emf;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager em) {
        Conexion.em = em;
    }

    //obtener hora del servidor
    public static Query Query_Fecha_Actual() {
        String Cons = "SELECT NOW()";
        Query qy = em.createNativeQuery(Cons);
        return qy;
    }

    public static Date Fecha_Actual(String fecha) throws ParseException, java.text.ParseException {
        Date fecha2;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        fecha2 = formatoDelTexto.parse(fecha);
        return fecha2;
    }

    public static Date getFechaActual() throws ParseException, java.text.ParseException {
        return Fecha_Actual(Query_Fecha_Actual().getSingleResult().toString());
    }

}
