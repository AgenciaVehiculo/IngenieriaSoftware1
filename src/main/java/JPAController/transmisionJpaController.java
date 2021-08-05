/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.transmision;
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
public class transmisionJpaController implements Serializable {

    public transmisionJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(transmision transmision) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(transmision);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findtransmision(transmision.getId_transmision()) != null) {
                throw new PreexistingEntityException("transmision " + transmision + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(transmision transmision) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            transmision = em.merge(transmision);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = transmision.getId_transmision();
                if (findtransmision(id) == null) {
                    throw new NonexistentEntityException("The transmision with id " + id + " no longer exists.");
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
            transmision transmision;
            try {
                transmision = em.getReference(transmision.class, id);
                transmision.getId_transmision();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transmision with id " + id + " no longer exists.", enfe);
            }
            em.remove(transmision);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<transmision> findtransmisionEntities() {
        return findtransmisionEntities(true, -1, -1);
    }

    public List<transmision> findtransmisionEntities(int maxResults, int firstResult) {
        return findtransmisionEntities(false, maxResults, firstResult);
    }

    private List<transmision> findtransmisionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(transmision.class));
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

    public transmision findtransmision(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(transmision.class, id);
        } finally {
            em.close();
        }
    }

    public int gettransmisionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<transmision> rt = cq.from(transmision.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
