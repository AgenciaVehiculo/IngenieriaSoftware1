/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoCabina;
import JPAController.exceptions.NonexistentEntityException;
import JPAController.exceptions.PreexistingEntityException;
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
 * @author Usuario
 */
public class TipoCabinaJpaController implements Serializable {

    public TipoCabinaJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoCabina tipoCabina) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoCabina);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoCabina(tipoCabina.getIdTipoCabina()) != null) {
                throw new PreexistingEntityException("TipoCabina " + tipoCabina + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoCabina tipoCabina) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoCabina = em.merge(tipoCabina);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoCabina.getIdTipoCabina();
                if (findTipoCabina(id) == null) {
                    throw new NonexistentEntityException("The tipoCabina with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoCabina tipoCabina;
            try {
                tipoCabina = em.getReference(TipoCabina.class, id);
                tipoCabina.getIdTipoCabina();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoCabina with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoCabina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoCabina> findTipoCabinaEntities() {
        return findTipoCabinaEntities(true, -1, -1);
    }

    public List<TipoCabina> findTipoCabinaEntities(int maxResults, int firstResult) {
        return findTipoCabinaEntities(false, maxResults, firstResult);
    }

    private List<TipoCabina> findTipoCabinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoCabina.class));
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

    public TipoCabina findTipoCabina(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoCabina.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoCabinaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoCabina> rt = cq.from(TipoCabina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
