/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.PiezaFactura;
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
 * @author Kur013
 */
public class PiezaFacturaJpaController implements Serializable {

    public PiezaFacturaJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PiezaFactura piezaFactura) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(piezaFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPiezaFactura(piezaFactura.getIdPieza()) != null) {
                throw new PreexistingEntityException("PiezaFactura " + piezaFactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PiezaFactura piezaFactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            piezaFactura = em.merge(piezaFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = piezaFactura.getIdPieza();
                if (findPiezaFactura(id) == null) {
                    throw new NonexistentEntityException("The piezaFactura with id " + id + " no longer exists.");
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
            PiezaFactura piezaFactura;
            try {
                piezaFactura = em.getReference(PiezaFactura.class, id);
                piezaFactura.getIdPieza();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The piezaFactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(piezaFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PiezaFactura> findPiezaFacturaEntities() {
        return findPiezaFacturaEntities(true, -1, -1);
    }

    public List<PiezaFactura> findPiezaFacturaEntities(int maxResults, int firstResult) {
        return findPiezaFacturaEntities(false, maxResults, firstResult);
    }

    private List<PiezaFactura> findPiezaFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PiezaFactura.class));
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

    public PiezaFactura findPiezaFactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PiezaFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getPiezaFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PiezaFactura> rt = cq.from(PiezaFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
