/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.TipoVehiculo;
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
public class TipoVehiculoJpaController implements Serializable {

    public TipoVehiculoJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoVehiculo tipoVehiculo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoVehiculo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoVehiculo(tipoVehiculo.getIdTipoVehiculo()) != null) {
                throw new PreexistingEntityException("TipoVehiculo " + tipoVehiculo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoVehiculo tipoVehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoVehiculo = em.merge(tipoVehiculo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoVehiculo.getIdTipoVehiculo();
                if (findTipoVehiculo(id) == null) {
                    throw new NonexistentEntityException("The tipoVehiculo with id " + id + " no longer exists.");
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
            TipoVehiculo tipoVehiculo;
            try {
                tipoVehiculo = em.getReference(TipoVehiculo.class, id);
                tipoVehiculo.getIdTipoVehiculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoVehiculo with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoVehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoVehiculo> findTipoVehiculoEntities() {
        return findTipoVehiculoEntities(true, -1, -1);
    }

    public List<TipoVehiculo> findTipoVehiculoEntities(int maxResults, int firstResult) {
        return findTipoVehiculoEntities(false, maxResults, firstResult);
    }

    private List<TipoVehiculo> findTipoVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoVehiculo.class));
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

    public TipoVehiculo findTipoVehiculo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoVehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoVehiculo> rt = cq.from(TipoVehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
