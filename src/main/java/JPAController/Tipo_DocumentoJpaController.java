/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPAController;

import Clases.Tipo_Documento;
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
public class Tipo_DocumentoJpaController implements Serializable {

    public Tipo_DocumentoJpaController() {
        this.emf= Persistence.createEntityManagerFactory("CarSoft");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipo_Documento tipo_Documento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipo_Documento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipo_Documento(tipo_Documento.getId_Tipo_Documento()) != null) {
                throw new PreexistingEntityException("Tipo_Documento " + tipo_Documento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipo_Documento tipo_Documento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipo_Documento = em.merge(tipo_Documento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipo_Documento.getId_Tipo_Documento();
                if (findTipo_Documento(id) == null) {
                    throw new NonexistentEntityException("The tipo_Documento with id " + id + " no longer exists.");
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
            Tipo_Documento tipo_Documento;
            try {
                tipo_Documento = em.getReference(Tipo_Documento.class, id);
                tipo_Documento.getId_Tipo_Documento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipo_Documento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipo_Documento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipo_Documento> findTipo_DocumentoEntities() {
        return findTipo_DocumentoEntities(true, -1, -1);
    }

    public List<Tipo_Documento> findTipo_DocumentoEntities(int maxResults, int firstResult) {
        return findTipo_DocumentoEntities(false, maxResults, firstResult);
    }

    private List<Tipo_Documento> findTipo_DocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipo_Documento.class));
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

    public Tipo_Documento findTipo_Documento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipo_Documento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipo_DocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipo_Documento> rt = cq.from(Tipo_Documento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
