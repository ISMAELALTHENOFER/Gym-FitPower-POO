package fitpower.controller;

import fitpower.dao.Conexion;
import fitpower.dao.exceptions.NonexistentEntityException;
import fitpower.dao.CustomerJpaController;
import java.util.ArrayList;
import java.util.List;
import fitpower.model.Customer;

/**
 * Controlador de operaciones relacionadas con entidades Customer (clientes).
 * Encapsula lógica de negocio para creación, modificación, eliminación y
 * búsqueda.
 *
 * @author Ismael
 */
public class CustomerController {

    // DAO para acceder a la entidad Customer
    private final CustomerJpaController personaDAO;

    public CustomerController() {
        // Se obtiene el EntityManagerFactory desde la clase Conexion (Singleton)
        this.personaDAO = new CustomerJpaController(Conexion.getEmf());
        System.out.println("CustomerController inicializado.");
    }

    /**
     * Agrega una nueva persona si el DNI no está repetido.
     *
     * @param nuevaPersona Entidad Customer a agregar
     * @return true si fue agregado, false si el DNI ya existe
     */
    public boolean agregarPersona(Customer nuevaPersona) {
        System.out.println("Intentando agregar persona con DNI: " + nuevaPersona.getDni());
        boolean dniPermitido = true;

        for (Customer personaRecorrido : personaDAO.findCustomerEntities()) {
            if (nuevaPersona.getDni().equals(personaRecorrido.getDni())) {
                System.out.println("DNI duplicado encontrado: " + nuevaPersona.getDni());
                dniPermitido = false;
                break;
            }
        }

        if (dniPermitido) {
            personaDAO.create(nuevaPersona);
            System.out.println("Persona agregada correctamente: " + nuevaPersona.getName());
        } else {
            System.out.println("No se pudo agregar persona, DNI ya existe.");
        }

        return dniPermitido;
    }

    /**
     * Modifica una persona si el nuevo DNI no está en uso por otro.
     *
     * @param actualPersona La entidad existente
     * @param nuevaPersona Datos nuevos para actualizar
     * @return true si se pudo modificar, false si el DNI ya está en uso
     * @throws Exception Si ocurre un error en la edición
     */
    public boolean modificarPersona(Customer actualPersona, Customer nuevaPersona) throws Exception {
        System.out.println("Intentando modificar persona con ID: " + actualPersona.getId());

        nuevaPersona.setId(actualPersona.getId()); // mantener el ID original
        boolean dniPermitido = true;

        if (actualPersona.getDni().equals(nuevaPersona.getDni())) {
            // DNI no cambió, se puede editar directamente
            personaDAO.edit(nuevaPersona);
            System.out.println("Persona modificada (mismo DNI): " + nuevaPersona.getName());
        } else {
            // Verificar si el nuevo DNI ya está en uso
            for (Customer personaRecorrido : personaDAO.findCustomerEntities()) {
                if (nuevaPersona.getDni().equals(personaRecorrido.getDni())) {
                    System.out.println("Nuevo DNI ya existe en otra persona: " + nuevaPersona.getDni());
                    dniPermitido = false;
                    break;
                }
            }

            if (dniPermitido) {
                personaDAO.edit(nuevaPersona);
                System.out.println("Persona modificada correctamente con nuevo DNI.");
            } else {
                System.out.println("No se pudo modificar, nuevo DNI en uso.");
            }
        }

        return dniPermitido;
    }

    /**
     * Elimina una persona si es permitido por la lógica de negocio.
     *
     * @param personaAEliminar Persona a eliminar
     * @return true si fue eliminada, false si no fue posible
     * @throws NonexistentEntityException Si no se encuentra la entidad
     */
    public boolean eliminarPersona(Customer personaAEliminar) throws NonexistentEntityException {
        System.out.println("Intentando eliminar persona con ID: " + personaAEliminar.getId());
        boolean estadoEliminacionUsuario = true;

        if (verificarEliminarPersona(personaAEliminar)) {
            personaDAO.destroy(personaAEliminar.getId());
            System.out.println("Persona eliminada correctamente.");
        } else {
            estadoEliminacionUsuario = false;
            System.out.println("No se puede eliminar la persona por restricciones de negocio.");
        }

        return estadoEliminacionUsuario;
    }

    /**
     * Retorna la lista completa de personas.
     *
     * @return Lista de Customer
     */
    public List<Customer> buscarTodasLasPersonas() {
        System.out.println("Buscando todas las personas...");
        return personaDAO.findCustomerEntities();
    }

    /**
     * Busca personas cuyo DNI contenga el texto indicado.
     *
     * @param dni Fragmento de DNI a buscar
     * @return Lista de personas que coinciden
     */
    public List<Customer> buscarPersonasPorDNI(String dni) {
        System.out.println("Buscando personas por DNI: " + dni);
        List<Customer> personasEncontradas = new ArrayList<>();

        for (Customer personaRecorrido : personaDAO.findCustomerEntities()) {
            if (personaRecorrido.getDni().contains(dni)) {
                personasEncontradas.add(personaRecorrido);
            }
        }

        System.out.println("Cantidad de personas encontradas: " + personasEncontradas.size());
        return personasEncontradas;
    }

    /**
     * Valida si una persona puede ser eliminada. Por ahora siempre devuelve
     * true.
     *
     * @param personaAEliminar Persona a evaluar
     * @return true si puede ser eliminada
     */
    private boolean verificarEliminarPersona(Customer personaAEliminar) {
        // Aquí podrías agregar validaciones como si tiene facturas asociadas, etc.
        return true;
    }
}
