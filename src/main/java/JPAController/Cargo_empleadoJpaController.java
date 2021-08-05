/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Cargo_empleado;
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
public class Cargo_empleadoJpaController implements Serializable {

    public Cargo_empleadoJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft"); 
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cargo_empleado cargo_empleado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cargo_empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCargo_empleado(cargo_empleado.getId_cargo()) != null) {
                throw new PreexistingEntityException("Cargo_empleado " + cargo_empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cargo_empleado cargo_empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cargo_empleado = em.merge(cargo_empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cargo_empleado.getId_cargo();
                if (findCargo_empleado(id) == null) {
                    throw new NonexistentEntityException("The cargo_empleado with id " + id + " no longer exists.");
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
            Cargo_empleado cargo_empleado;
            try {
                cargo_empleado = em.getReference(Cargo_empleado.class, id);
                cargo_empleado.getId_cargo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargo_empleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(cargo_empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cargo_empleado> findCargo_empleadoEntities() {
        return findCargo_empleadoEntities(true, -1, -1);
    }

    public List<Cargo_empleado> findCargo_empleadoEntities(int maxResults, int firstResult) {
        return findCargo_empleadoEntities(false, maxResults, firstResult);
    }

    private List<Cargo_empleado> findCargo_empleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cargo_empleado.class));
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

    public Cargo_empleado findCargo_empleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cargo_empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargo_empleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cargo_empleado> rt = cq.from(Cargo_empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
