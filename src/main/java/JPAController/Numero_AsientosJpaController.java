/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Numero_Asientos;
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
public class Numero_AsientosJpaController implements Serializable {

    public Numero_AsientosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Numero_Asientos numero_Asientos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(numero_Asientos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNumero_Asientos(numero_Asientos.getId_Numero_Asientos()) != null) {
                throw new PreexistingEntityException("Numero_Asientos " + numero_Asientos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Numero_Asientos numero_Asientos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            numero_Asientos = em.merge(numero_Asientos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = numero_Asientos.getId_Numero_Asientos();
                if (findNumero_Asientos(id) == null) {
                    throw new NonexistentEntityException("The numero_Asientos with id " + id + " no longer exists.");
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
            Numero_Asientos numero_Asientos;
            try {
                numero_Asientos = em.getReference(Numero_Asientos.class, id);
                numero_Asientos.getId_Numero_Asientos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The numero_Asientos with id " + id + " no longer exists.", enfe);
            }
            em.remove(numero_Asientos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Numero_Asientos> findNumero_AsientosEntities() {
        return findNumero_AsientosEntities(true, -1, -1);
    }

    public List<Numero_Asientos> findNumero_AsientosEntities(int maxResults, int firstResult) {
        return findNumero_AsientosEntities(false, maxResults, firstResult);
    }

    private List<Numero_Asientos> findNumero_AsientosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Numero_Asientos.class));
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

    public Numero_Asientos findNumero_Asientos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Numero_Asientos.class, id);
        } finally {
            em.close();
        }
    }

    public int getNumero_AsientosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Numero_Asientos> rt = cq.from(Numero_Asientos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
