/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.HistoricoSueldo_empleado;
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
public class HistoricoSueldo_empleadoJpaController implements Serializable {

    public HistoricoSueldo_empleadoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistoricoSueldo_empleado historicoSueldo_empleado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(historicoSueldo_empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoricoSueldo_empleado(historicoSueldo_empleado.getId_sueldo()) != null) {
                throw new PreexistingEntityException("HistoricoSueldo_empleado " + historicoSueldo_empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistoricoSueldo_empleado historicoSueldo_empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            historicoSueldo_empleado = em.merge(historicoSueldo_empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = historicoSueldo_empleado.getId_sueldo();
                if (findHistoricoSueldo_empleado(id) == null) {
                    throw new NonexistentEntityException("The historicoSueldo_empleado with id " + id + " no longer exists.");
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
            HistoricoSueldo_empleado historicoSueldo_empleado;
            try {
                historicoSueldo_empleado = em.getReference(HistoricoSueldo_empleado.class, id);
                historicoSueldo_empleado.getId_sueldo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicoSueldo_empleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(historicoSueldo_empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistoricoSueldo_empleado> findHistoricoSueldo_empleadoEntities() {
        return findHistoricoSueldo_empleadoEntities(true, -1, -1);
    }

    public List<HistoricoSueldo_empleado> findHistoricoSueldo_empleadoEntities(int maxResults, int firstResult) {
        return findHistoricoSueldo_empleadoEntities(false, maxResults, firstResult);
    }

    private List<HistoricoSueldo_empleado> findHistoricoSueldo_empleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistoricoSueldo_empleado.class));
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

    public HistoricoSueldo_empleado findHistoricoSueldo_empleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistoricoSueldo_empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricoSueldo_empleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistoricoSueldo_empleado> rt = cq.from(HistoricoSueldo_empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
