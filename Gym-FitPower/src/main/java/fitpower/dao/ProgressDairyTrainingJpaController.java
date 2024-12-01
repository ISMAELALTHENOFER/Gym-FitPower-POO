/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.dao;

import fitpower.dao.exceptions.NonexistentEntityException;
import fitpower.model.ProgressDairyTraining;
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
public class ProgressDairyTrainingJpaController implements Serializable {

    public ProgressDairyTrainingJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProgressDairyTraining progressDairyTraining) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(progressDairyTraining);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProgressDairyTraining progressDairyTraining) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            progressDairyTraining = em.merge(progressDairyTraining);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = progressDairyTraining.getId();
                if (findProgressDairyTraining(id) == null) {
                    throw new NonexistentEntityException("The progressDairyTraining with id " + id + " no longer exists.");
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
            ProgressDairyTraining progressDairyTraining;
            try {
                progressDairyTraining = em.getReference(ProgressDairyTraining.class, id);
                progressDairyTraining.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The progressDairyTraining with id " + id + " no longer exists.", enfe);
            }
            em.remove(progressDairyTraining);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProgressDairyTraining> findProgressDairyTrainingEntities() {
        return findProgressDairyTrainingEntities(true, -1, -1);
    }

    public List<ProgressDairyTraining> findProgressDairyTrainingEntities(int maxResults, int firstResult) {
        return findProgressDairyTrainingEntities(false, maxResults, firstResult);
    }

    private List<ProgressDairyTraining> findProgressDairyTrainingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProgressDairyTraining.class));
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

    public ProgressDairyTraining findProgressDairyTraining(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProgressDairyTraining.class, id);
        } finally {
            em.close();
        }
    }

    public int getProgressDairyTrainingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProgressDairyTraining> rt = cq.from(ProgressDairyTraining.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
