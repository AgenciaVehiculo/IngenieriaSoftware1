/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.VehiculoFactura;
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
public class VehiculoFacturaJpaController implements Serializable {

    public VehiculoFacturaJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VehiculoFactura vehiculoFactura) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vehiculoFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVehiculoFactura(vehiculoFactura.getIdVehiculo()) != null) {
                throw new PreexistingEntityException("VehiculoFactura " + vehiculoFactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VehiculoFactura vehiculoFactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vehiculoFactura = em.merge(vehiculoFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = vehiculoFactura.getIdVehiculo();
                if (findVehiculoFactura(id) == null) {
                    throw new NonexistentEntityException("The vehiculoFactura with id " + id + " no longer exists.");
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
            VehiculoFactura vehiculoFactura;
            try {
                vehiculoFactura = em.getReference(VehiculoFactura.class, id);
                vehiculoFactura.getIdVehiculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculoFactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(vehiculoFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VehiculoFactura> findVehiculoFacturaEntities() {
        return findVehiculoFacturaEntities(true, -1, -1);
    }

    public List<VehiculoFactura> findVehiculoFacturaEntities(int maxResults, int firstResult) {
        return findVehiculoFacturaEntities(false, maxResults, firstResult);
    }

    private List<VehiculoFactura> findVehiculoFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VehiculoFactura.class));
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

    public VehiculoFactura findVehiculoFactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VehiculoFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VehiculoFactura> rt = cq.from(VehiculoFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
