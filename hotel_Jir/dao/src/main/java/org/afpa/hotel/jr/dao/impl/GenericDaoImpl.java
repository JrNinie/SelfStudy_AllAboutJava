package org.afpa.hotel.jr.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.afpa.hotel.jr.dao.impl.utils.JpaUtil;
import org.afpa.hotel.jr.dao.jpa.DAO;

public abstract class GenericDaoImpl<T, ID> implements DAO<T, ID> {

	private Class<T> clazz=getClazz();

	public final void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	abstract public Class<T> getClazz();

	// Créer un EM et ouvrir une transaction
	protected EntityManager getEntityManager() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();

		return (em);
	}

	// Fermer un EM et défaire la transaction si nécessaire
	protected void closeEntityManager(EntityManager em) {
		if (em != null) {
			if (em.isOpen()) {
				EntityTransaction t = em.getTransaction();
				if (t.isActive()) {
					try {
						t.rollback();
					} catch (PersistenceException e) {
					}
				}
				em.close();
			}
		}
	}

	public T create(T t) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			closeEntityManager(em);
		}
		return t;
	}

	public void delete(T t) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			closeEntityManager(em);
		}
	}
	public void deleteById(ID id) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			T t = (T) em.find(clazz, id);
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			closeEntityManager(em);
		}
	}
	public T update(T t) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			closeEntityManager(em);
		}
		return t;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findById(ID id) {
		EntityManager em = getEntityManager();
		T t;
		try {
			t = (T) em.find(clazz, id);
		} finally {
			closeEntityManager(em);
		}
		return t;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		EntityManager em = getEntityManager();
		List<T> list;
		try {
			em.getTransaction().begin();
			String req = "select Object(t) from " + clazz.getName() + " t";
			//String req = "select t from " + clazz.getName() + " t";
			list = em.createQuery(req, clazz).getResultList();

		} finally {
			closeEntityManager(em);
		}
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int count() {
		
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(clazz);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }

	}
	
    public List<T> findEntities() {
        return findEntities(true, -1, -1);
    }

    public List<T> findAll(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    @SuppressWarnings("unchecked")
	private List<T> findEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            @SuppressWarnings("rawtypes")
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
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

}
