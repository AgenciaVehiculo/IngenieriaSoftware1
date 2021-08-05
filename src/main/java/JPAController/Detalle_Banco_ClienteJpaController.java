/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Detalle_Banco_Cliente;
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
public class Detalle_Banco_ClienteJpaController implements Serializable {

    public Detalle_Banco_ClienteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detalle_Banco_Cliente detalle_Banco_Cliente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalle_Banco_Cliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalle_Banco_Cliente(detalle_Banco_Cliente.getNumero_prestamo()) != null) {
                throw new PreexistingEntityException("Detalle_Banco_Cliente " + detalle_Banco_Cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detalle_Banco_Cliente detalle_Banco_Cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalle_Banco_Cliente = em.merge(detalle_Banco_Cliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = detalle_Banco_Cliente.getNumero_prestamo();
                if (findDetalle_Banco_Cliente(id) == null) {
                    throw new NonexistentEntityException("The detalle_Banco_Cliente with id " + id + " no longer exists.");
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
            Detalle_Banco_Cliente detalle_Banco_Cliente;
            try {
                detalle_Banco_Cliente = em.getReference(Detalle_Banco_Cliente.class, id);
                detalle_Banco_Cliente.getNumero_prestamo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalle_Banco_Cliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalle_Banco_Cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detalle_Banco_Cliente> findDetalle_Banco_ClienteEntities() {
        return findDetalle_Banco_ClienteEntities(true, -1, -1);
    }

    public List<Detalle_Banco_Cliente> findDetalle_Banco_ClienteEntities(int maxResults, int firstResult) {
        return findDetalle_Banco_ClienteEntities(false, maxResults, firstResult);
    }

    private List<Detalle_Banco_Cliente> findDetalle_Banco_ClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detalle_Banco_Cliente.class));
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

    public Detalle_Banco_Cliente findDetalle_Banco_Cliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detalle_Banco_Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalle_Banco_ClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detalle_Banco_Cliente> rt = cq.from(Detalle_Banco_Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
