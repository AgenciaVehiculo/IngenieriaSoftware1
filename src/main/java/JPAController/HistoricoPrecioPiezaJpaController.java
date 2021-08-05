/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.HistoricoPrecioPieza;
import JPAController.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kur013
 */
public class HistoricoPrecioPiezaJpaController implements Serializable {

    public HistoricoPrecioPiezaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistoricoPrecioPieza historicoPrecioPieza) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(historicoPrecioPieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistoricoPrecioPieza historicoPrecioPieza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            historicoPrecioPieza = em.merge(historicoPrecioPieza);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historicoPrecioPieza.getIdPrecioHistorico();
                if (findHistoricoPrecioPieza(id) == null) {
                    throw new NonexistentEntityException("The historicoPrecioPieza with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HistoricoPrecioPieza historicoPrecioPieza;
            try {
                historicoPrecioPieza = em.getReference(HistoricoPrecioPieza.class, id);
                historicoPrecioPieza.getIdPrecioHistorico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicoPrecioPieza with id " + id + " no longer exists.", enfe);
            }
            em.remove(historicoPrecioPieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistoricoPrecioPieza> findHistoricoPrecioPiezaEntities() {
        return findHistoricoPrecioPiezaEntities(true, -1, -1);
    }

    public List<HistoricoPrecioPieza> findHistoricoPrecioPiezaEntities(int maxResults, int firstResult) {
        return findHistoricoPrecioPiezaEntities(false, maxResults, firstResult);
    }

    private List<HistoricoPrecioPieza> findHistoricoPrecioPiezaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistoricoPrecioPieza.class));
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

    public HistoricoPrecioPieza findHistoricoPrecioPieza(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistoricoPrecioPieza.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricoPrecioPiezaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistoricoPrecioPieza> rt = cq.from(HistoricoPrecioPieza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
