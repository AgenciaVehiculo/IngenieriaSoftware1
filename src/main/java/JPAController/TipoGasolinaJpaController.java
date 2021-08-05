/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoGasolina;
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
public class TipoGasolinaJpaController implements Serializable {

    public TipoGasolinaJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoGasolina tipoGasolina) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoGasolina);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoGasolina(tipoGasolina.getIdTipoGasolina()) != null) {
                throw new PreexistingEntityException("TipoGasolina " + tipoGasolina + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoGasolina tipoGasolina) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoGasolina = em.merge(tipoGasolina);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoGasolina.getIdTipoGasolina();
                if (findTipoGasolina(id) == null) {
                    throw new NonexistentEntityException("The tipoGasolina with id " + id + " no longer exists.");
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
            TipoGasolina tipoGasolina;
            try {
                tipoGasolina = em.getReference(TipoGasolina.class, id);
                tipoGasolina.getIdTipoGasolina();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoGasolina with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoGasolina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoGasolina> findTipoGasolinaEntities() {
        return findTipoGasolinaEntities(true, -1, -1);
    }

    public List<TipoGasolina> findTipoGasolinaEntities(int maxResults, int firstResult) {
        return findTipoGasolinaEntities(false, maxResults, firstResult);
    }

    private List<TipoGasolina> findTipoGasolinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoGasolina.class));
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

    public TipoGasolina findTipoGasolina(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoGasolina.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoGasolinaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoGasolina> rt = cq.from(TipoGasolina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
