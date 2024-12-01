/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.dao;

import fitpower.dao.exceptions.NonexistentEntityException;
import fitpower.model.NotificationNutrition;
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
public class NotificationNutritionJpaController implements Serializable {

    public NotificationNutritionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NotificationNutrition notificationNutrition) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(notificationNutrition);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NotificationNutrition notificationNutrition) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            notificationNutrition = em.merge(notificationNutrition);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = notificationNutrition.getId();
                if (findNotificationNutrition(id) == null) {
                    throw new NonexistentEntityException("The notificationNutrition with id " + id + " no longer exists.");
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
            NotificationNutrition notificationNutrition;
            try {
                notificationNutrition = em.getReference(NotificationNutrition.class, id);
                notificationNutrition.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notificationNutrition with id " + id + " no longer exists.", enfe);
            }
            em.remove(notificationNutrition);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NotificationNutrition> findNotificationNutritionEntities() {
        return findNotificationNutritionEntities(true, -1, -1);
    }

    public List<NotificationNutrition> findNotificationNutritionEntities(int maxResults, int firstResult) {
        return findNotificationNutritionEntities(false, maxResults, firstResult);
    }

    private List<NotificationNutrition> findNotificationNutritionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NotificationNutrition.class));
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

    public NotificationNutrition findNotificationNutrition(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NotificationNutrition.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotificationNutritionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NotificationNutrition> rt = cq.from(NotificationNutrition.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
