package org.afpa.hotel.jr.dao.impl;

import javax.persistence.EntityManager;

import org.afpa.hotel.jr.dao.jpa.CategorieDao;
import org.afpa.hotel.jr.model.entities.Categorie;

public class CategorieDaoJpaImpl extends GenericDaoImpl<Categorie, Integer> implements CategorieDao {

	@Override
	public Class<Categorie> getClazz() {
		setClazz(Categorie.class);
		return Categorie.class;
	}

	@Override
	public Categorie findByNomcat(String nomcat) {
		EntityManager em = getEntityManager();
		Categorie categorie = null;
		try {
			em.getTransaction().begin();
			// String req1 = "select c from Categorie c WHERE c.nomcat = :cat ";
			// categorie = em.createQuery(req1, Categorie.class).setParameter("cat",
			// nomcat).getSingleResult();
			String req2 = "select c from Categorie c WHERE c.nomcat LIKE :cat ";
			categorie = em.createQuery(req2, Categorie.class).setParameter("cat", "%" + nomcat + "%").getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return categorie;
	}

	// usually we only deletebyid, so not necessary this method
	@Override
	public int deleteByNomcat(String nomcat) {
		EntityManager em = getEntityManager();
		int deleteNbr = 0;
		try {
			em.getTransaction().begin();
			String req1 = "DELETE FROM Categorie WHERE nomcat = :cat ";

			deleteNbr = em.createQuery(req1, Categorie.class).setParameter("cat", nomcat).executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return deleteNbr;

	}

}
