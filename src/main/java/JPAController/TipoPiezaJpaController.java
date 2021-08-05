/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoPieza;
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
public class TipoPiezaJpaController implements Serializable {

    public TipoPiezaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoPieza tipoPieza) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoPieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoPieza tipoPieza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoPieza = em.merge(tipoPieza);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoPieza.getIDtipopieza();
                if (findTipoPieza(id) == null) {
                    throw new NonexistentEntityException("The tipoPieza with id " + id + " no longer exists.");
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
            TipoPieza tipoPieza;
            try {
                tipoPieza = em.getReference(TipoPieza.class, id);
                tipoPieza.getIDtipopieza();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoPieza with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoPieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoPieza> findTipoPiezaEntities() {
        return findTipoPiezaEntities(true, -1, -1);
    }

    public List<TipoPieza> findTipoPiezaEntities(int maxResults, int firstResult) {
        return findTipoPiezaEntities(false, maxResults, firstResult);
    }

    private List<TipoPieza> findTipoPiezaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoPieza.class));
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

    public TipoPieza findTipoPieza(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoPieza.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoPiezaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoPieza> rt = cq.from(TipoPieza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
