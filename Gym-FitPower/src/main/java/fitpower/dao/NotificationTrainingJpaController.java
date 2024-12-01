/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.dao;

import fitpower.dao.exceptions.NonexistentEntityException;
import fitpower.model.NotificationTraining;
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
public class NotificationTrainingJpaController implements Serializable {

    public NotificationTrainingJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NotificationTraining notificationTraining) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(notificationTraining);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NotificationTraining notificationTraining) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            notificationTraining = em.merge(notificationTraining);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = notificationTraining.getId();
                if (findNotificationTraining(id) == null) {
                    throw new NonexistentEntityException("The notificationTraining with id " + id + " no longer exists.");
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
            NotificationTraining notificationTraining;
            try {
                notificationTraining = em.getReference(NotificationTraining.class, id);
                notificationTraining.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notificationTraining with id " + id + " no longer exists.", enfe);
            }
            em.remove(notificationTraining);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NotificationTraining> findNotificationTrainingEntities() {
        return findNotificationTrainingEntities(true, -1, -1);
    }

    public List<NotificationTraining> findNotificationTrainingEntities(int maxResults, int firstResult) {
        return findNotificationTrainingEntities(false, maxResults, firstResult);
    }

    private List<NotificationTraining> findNotificationTrainingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NotificationTraining.class));
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

    public NotificationTraining findNotificationTraining(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NotificationTraining.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotificationTrainingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NotificationTraining> rt = cq.from(NotificationTraining.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
