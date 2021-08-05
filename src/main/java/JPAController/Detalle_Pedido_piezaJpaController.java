/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Detalle_Pedido_pieza;
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
public class Detalle_Pedido_piezaJpaController implements Serializable {

    public Detalle_Pedido_piezaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detalle_Pedido_pieza detalle_Pedido_pieza) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalle_Pedido_pieza);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalle_Pedido_pieza(detalle_Pedido_pieza.getId_pedido()) != null) {
                throw new PreexistingEntityException("Detalle_Pedido_pieza " + detalle_Pedido_pieza + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detalle_Pedido_pieza detalle_Pedido_pieza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalle_Pedido_pieza = em.merge(detalle_Pedido_pieza);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = detalle_Pedido_pieza.getId_pedido();
                if (findDetalle_Pedido_pieza(id) == null) {
                    throw new NonexistentEntityException("The detalle_Pedido_pieza with id " + id + " no longer exists.");
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
            Detalle_Pedido_pieza detalle_Pedido_pieza;
            try {
                detalle_Pedido_pieza = em.getReference(Detalle_Pedido_pieza.class, id);
                detalle_Pedido_pieza.getId_pedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalle_Pedido_pieza with id " + id + " no longer exists.", enfe);
            }
            em.remove(detalle_Pedido_pieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detalle_Pedido_pieza> findDetalle_Pedido_piezaEntities() {
        return findDetalle_Pedido_piezaEntities(true, -1, -1);
    }

    public List<Detalle_Pedido_pieza> findDetalle_Pedido_piezaEntities(int maxResults, int firstResult) {
        return findDetalle_Pedido_piezaEntities(false, maxResults, firstResult);
    }

    private List<Detalle_Pedido_pieza> findDetalle_Pedido_piezaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detalle_Pedido_pieza.class));
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

    public Detalle_Pedido_pieza findDetalle_Pedido_pieza(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detalle_Pedido_pieza.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalle_Pedido_piezaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detalle_Pedido_pieza> rt = cq.from(Detalle_Pedido_pieza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
