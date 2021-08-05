/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.HistoricoPrecioVehiculos;
import JPAController.exceptions.NonexistentEntityException;
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
 * @author Kur013
 */
public class HistoricoPrecioVehiculosJpaController implements Serializable {

    public HistoricoPrecioVehiculosJpaController() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistoricoPrecioVehiculos historicoPrecioVehiculos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(historicoPrecioVehiculos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistoricoPrecioVehiculos historicoPrecioVehiculos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            historicoPrecioVehiculos = em.merge(historicoPrecioVehiculos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historicoPrecioVehiculos.getIdPrecioHistorico();
                if (findHistoricoPrecioVehiculos(id) == null) {
                    throw new NonexistentEntityException("The historicoPrecioVehiculos with id " + id + " no longer exists.");
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
            HistoricoPrecioVehiculos historicoPrecioVehiculos;
            try {
                historicoPrecioVehiculos = em.getReference(HistoricoPrecioVehiculos.class, id);
                historicoPrecioVehiculos.getIdPrecioHistorico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicoPrecioVehiculos with id " + id + " no longer exists.", enfe);
            }
            em.remove(historicoPrecioVehiculos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistoricoPrecioVehiculos> findHistoricoPrecioVehiculosEntities() {
        return findHistoricoPrecioVehiculosEntities(true, -1, -1);
    }

    public List<HistoricoPrecioVehiculos> findHistoricoPrecioVehiculosEntities(int maxResults, int firstResult) {
        return findHistoricoPrecioVehiculosEntities(false, maxResults, firstResult);
    }

    private List<HistoricoPrecioVehiculos> findHistoricoPrecioVehiculosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistoricoPrecioVehiculos.class));
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

    public HistoricoPrecioVehiculos findHistoricoPrecioVehiculos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistoricoPrecioVehiculos.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricoPrecioVehiculosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistoricoPrecioVehiculos> rt = cq.from(HistoricoPrecioVehiculos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
