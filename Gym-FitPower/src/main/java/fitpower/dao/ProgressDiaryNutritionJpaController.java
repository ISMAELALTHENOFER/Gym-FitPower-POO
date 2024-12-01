/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.dao;

import fitpower.dao.exceptions.NonexistentEntityException;
import fitpower.model.ProgressDiaryNutrition;
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
public class ProgressDiaryNutritionJpaController implements Serializable {

    public ProgressDiaryNutritionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProgressDiaryNutrition progressDiaryNutrition) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(progressDiaryNutrition);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProgressDiaryNutrition progressDiaryNutrition) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            progressDiaryNutrition = em.merge(progressDiaryNutrition);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = progressDiaryNutrition.getId();
                if (findProgressDiaryNutrition(id) == null) {
                    throw new NonexistentEntityException("The progressDiaryNutrition with id " + id + " no longer exists.");
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
            ProgressDiaryNutrition progressDiaryNutrition;
            try {
                progressDiaryNutrition = em.getReference(ProgressDiaryNutrition.class, id);
                progressDiaryNutrition.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The progressDiaryNutrition with id " + id + " no longer exists.", enfe);
            }
            em.remove(progressDiaryNutrition);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProgressDiaryNutrition> findProgressDiaryNutritionEntities() {
        return findProgressDiaryNutritionEntities(true, -1, -1);
    }

    public List<ProgressDiaryNutrition> findProgressDiaryNutritionEntities(int maxResults, int firstResult) {
        return findProgressDiaryNutritionEntities(false, maxResults, firstResult);
    }

    private List<ProgressDiaryNutrition> findProgressDiaryNutritionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProgressDiaryNutrition.class));
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

    public ProgressDiaryNutrition findProgressDiaryNutrition(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProgressDiaryNutrition.class, id);
        } finally {
            em.close();
        }
    }

    public int getProgressDiaryNutritionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProgressDiaryNutrition> rt = cq.from(ProgressDiaryNutrition.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
