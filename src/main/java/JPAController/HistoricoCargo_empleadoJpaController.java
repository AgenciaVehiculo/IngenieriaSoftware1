/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.HistoricoCargo_empleado;
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
public class HistoricoCargo_empleadoJpaController implements Serializable {

    public HistoricoCargo_empleadoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistoricoCargo_empleado historicoCargo_empleado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(historicoCargo_empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoricoCargo_empleado(historicoCargo_empleado.getId_cargo_historico()) != null) {
                throw new PreexistingEntityException("HistoricoCargo_empleado " + historicoCargo_empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistoricoCargo_empleado historicoCargo_empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            historicoCargo_empleado = em.merge(historicoCargo_empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = historicoCargo_empleado.getId_cargo_historico();
                if (findHistoricoCargo_empleado(id) == null) {
                    throw new NonexistentEntityException("The historicoCargo_empleado with id " + id + " no longer exists.");
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
            HistoricoCargo_empleado historicoCargo_empleado;
            try {
                historicoCargo_empleado = em.getReference(HistoricoCargo_empleado.class, id);
                historicoCargo_empleado.getId_cargo_historico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicoCargo_empleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(historicoCargo_empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistoricoCargo_empleado> findHistoricoCargo_empleadoEntities() {
        return findHistoricoCargo_empleadoEntities(true, -1, -1);
    }

    public List<HistoricoCargo_empleado> findHistoricoCargo_empleadoEntities(int maxResults, int firstResult) {
        return findHistoricoCargo_empleadoEntities(false, maxResults, firstResult);
    }

    private List<HistoricoCargo_empleado> findHistoricoCargo_empleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistoricoCargo_empleado.class));
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

    public HistoricoCargo_empleado findHistoricoCargo_empleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistoricoCargo_empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricoCargo_empleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistoricoCargo_empleado> rt = cq.from(HistoricoCargo_empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
