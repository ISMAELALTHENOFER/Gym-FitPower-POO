/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.dao;

import fitpower.dao.exceptions.NonexistentEntityException;
import fitpower.model.Users;
import fitpower.model.UserType;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Ismael
 */
public class UserJpaController implements Serializable {

    public UserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Users user) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UserType userType = user.getUserType();
            if (userType != null) {
                userType = em.getReference(userType.getClass(), userType.getId());
                user.setUserType(userType);
            }
            em.persist(user);
            if (userType != null) {
                userType.getUsers().add(user);
                userType = em.merge(userType);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Users user) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users persistentUsuario = em.find(Users.class, user.getId());
            UserType tipoUsuarioOld = persistentUsuario.getUserType();
            UserType tipoUsuarioNew = user.getUserType();
            if (tipoUsuarioNew != null) {
                tipoUsuarioNew = em.getReference(tipoUsuarioNew.getClass(), tipoUsuarioNew.getId());
                user.setUserType(tipoUsuarioNew);
            }
            user = em.merge(user);

            if (tipoUsuarioOld != null && !tipoUsuarioOld.equals(tipoUsuarioNew)) {
                tipoUsuarioOld.getUsers().remove(user);
                tipoUsuarioOld = em.merge(tipoUsuarioOld);
            }
            if (tipoUsuarioNew != null && !tipoUsuarioNew.equals(tipoUsuarioOld)) {
                tipoUsuarioNew.getUsers().add(user);
                tipoUsuarioNew = em.merge(tipoUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = user.getId();
                if (findUser(id) == null) {
                    throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users user;
            try {
                user = em.getReference(Users.class, id);
                user.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            UserType tipoUsuario = user.getUserType();
            if (tipoUsuario != null) {
                tipoUsuario.getUsers().remove(user);
                tipoUsuario = em.merge(tipoUsuario);
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Users> findUserEntities() {
        return findUserEntities(true, -1, -1);
    }

    public List<Users> findUserEntities(int maxResults, int firstResult) {
        return findUserEntities(false, maxResults, firstResult);
    }

    private List<Users> findUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Users findUser(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Users> rt = cq.from(Users.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Users startSession(Users us) {
        EntityManager em = getEntityManager();
        Users usuario = null;
        String consulta;
        try {
            System.out.println("Iniciando el método startSession...");
            System.out.println("Datos del usuario: username = " + us.getUsername() + ", password = " + us.getPassword());

            consulta = "FROM Users u WHERE u.username = :username AND u.password = :password";
            Query query = em.createQuery(consulta);
            query.setParameter("username", us.getUsername());
            query.setParameter("password", us.getPassword());

            System.out.println("Ejecutando la consulta JPQL...");
            List<Users> lista = query.getResultList();
            System.out.println("Consulta ejecutada. Tamaño de la lista: " + lista.size());

            if (!lista.isEmpty()) {
                usuario = lista.get(0);
                System.out.println("Usuario encontrado: " + usuario.getUsername());
            } else {
                System.out.println("No se encontró ningún usuario con las credenciales proporcionadas.");
            }
        } catch (Exception e) {
            System.err.println("Error en el método startSession: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            if (em != null) {
                em.close();
                System.out.println("EntityManager cerrado.");
            }
        }
        return usuario;
    }

    public Users verifyUser(Users us) {
        EntityManager em = getEntityManager();
        Users usuario = null;
        String consulta;
        try {
            System.out.println("Iniciando el método verifyUser...");
            System.out.println("Datos del usuario: username = " + us.getUsername());

            consulta = "FROM Users u WHERE u.username = :userName";
            Query query = em.createQuery(consulta);
            query.setParameter("userName", us.getUsername());

            System.out.println("Ejecutando la consulta JPQL...");
            List<Users> lista = query.getResultList();
            System.out.println("Consulta ejecutada. Tamaño de la lista: " + lista.size());

            if (!lista.isEmpty()) {
                usuario = lista.get(0);
                System.out.println("Usuario encontrado: " + usuario.getUsername());
            } else {
                System.out.println("No se encontró ningún usuario con el username proporcionado.");
            }
        } catch (Exception e) {
            System.err.println("Error en el método verifyUser: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            if (em != null) {
                em.close();
                System.out.println("EntityManager cerrado.");
            }
        }
        return usuario;
    }

}
