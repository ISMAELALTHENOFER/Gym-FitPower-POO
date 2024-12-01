/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.dao;

import fitpower.dao.exceptions.NonexistentEntityException;
import fitpower.model.NutritionPlan;
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
public class NutritionPlanJpaController implements Serializable {

    public NutritionPlanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NutritionPlan nutritionPlan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nutritionPlan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NutritionPlan nutritionPlan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nutritionPlan = em.merge(nutritionPlan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = nutritionPlan.getId();
                if (findNutritionPlan(id) == null) {
                    throw new NonexistentEntityException("The nutritionPlan with id " + id + " no longer exists.");
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
            NutritionPlan nutritionPlan;
            try {
                nutritionPlan = em.getReference(NutritionPlan.class, id);
                nutritionPlan.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nutritionPlan with id " + id + " no longer exists.", enfe);
            }
            em.remove(nutritionPlan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NutritionPlan> findNutritionPlanEntities() {
        return findNutritionPlanEntities(true, -1, -1);
    }

    public List<NutritionPlan> findNutritionPlanEntities(int maxResults, int firstResult) {
        return findNutritionPlanEntities(false, maxResults, firstResult);
    }

    private List<NutritionPlan> findNutritionPlanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NutritionPlan.class));
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

    public NutritionPlan findNutritionPlan(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NutritionPlan.class, id);
        } finally {
            em.close();
        }
    }

    public int getNutritionPlanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NutritionPlan> rt = cq.from(NutritionPlan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
