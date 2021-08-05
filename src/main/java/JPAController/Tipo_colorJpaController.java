/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Tipo_color;
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
public class Tipo_colorJpaController implements Serializable {

    public Tipo_colorJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipo_color tipo_color) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipo_color);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipo_color(tipo_color.getId_tipo_color()) != null) {
                throw new PreexistingEntityException("Tipo_color " + tipo_color + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipo_color tipo_color) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipo_color = em.merge(tipo_color);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipo_color.getId_tipo_color();
                if (findTipo_color(id) == null) {
                    throw new NonexistentEntityException("The tipo_color with id " + id + " no longer exists.");
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
            Tipo_color tipo_color;
            try {
                tipo_color = em.getReference(Tipo_color.class, id);
                tipo_color.getId_tipo_color();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipo_color with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipo_color);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipo_color> findTipo_colorEntities() {
        return findTipo_colorEntities(true, -1, -1);
    }

    public List<Tipo_color> findTipo_colorEntities(int maxResults, int firstResult) {
        return findTipo_colorEntities(false, maxResults, firstResult);
    }

    private List<Tipo_color> findTipo_colorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipo_color.class));
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

    public Tipo_color findTipo_color(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipo_color.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipo_colorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipo_color> rt = cq.from(Tipo_color.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
