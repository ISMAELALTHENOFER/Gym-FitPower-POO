/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitpower.dao;

import fitpower.dao.exceptions.NonexistentEntityException;
import fitpower.model.Nutritionist;
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
public class NutritionistJpaController implements Serializable {

    public NutritionistJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nutritionist nutritionist) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nutritionist);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nutritionist nutritionist) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nutritionist = em.merge(nutritionist);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = nutritionist.getId();
                if (findNutritionist(id) == null) {
                    throw new NonexistentEntityException("The nutritionist with id " + id + " no longer exists.");
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
            Nutritionist nutritionist;
            try {
                nutritionist = em.getReference(Nutritionist.class, id);
                nutritionist.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nutritionist with id " + id + " no longer exists.", enfe);
            }
            em.remove(nutritionist);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nutritionist> findNutritionistEntities() {
        return findNutritionistEntities(true, -1, -1);
    }

    public List<Nutritionist> findNutritionistEntities(int maxResults, int firstResult) {
        return findNutritionistEntities(false, maxResults, firstResult);
    }

    private List<Nutritionist> findNutritionistEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nutritionist.class));
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

    public Nutritionist findNutritionist(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nutritionist.class, id);
        } finally {
            em.close();
        }
    }

    public int getNutritionistCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nutritionist> rt = cq.from(Nutritionist.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
