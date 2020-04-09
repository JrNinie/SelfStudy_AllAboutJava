/**
 * 
 */
package org.afpa.hotel.jr.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.afpa.hotel.jr.dao.jpa.ChambreDao;
import org.afpa.hotel.jr.model.entities.Chambre;

public class ChambreDaoJpaImpl extends GenericDaoImpl<Chambre, Integer> implements ChambreDao {

	@Override
	public Class<Chambre> getClazz() {
		setClazz(Chambre.class);
		return Chambre.class;
	}
	
	@Override
	public List<Chambre> findByCategorie(String categorie) {
		EntityManager em = getEntityManager();
		List<Chambre> list = null;
		try {
			em.getTransaction().begin();
			String req = "select DISTINCT ch from Chambre ch INNER JOIN ch.categorie c WHERE c.nomcat = :cat ";
			list = em.createQuery(req, Chambre.class).setParameter("cat", categorie).getResultList();
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
		}
		finally {
			closeEntityManager(em);
		}
		return list;
	}

	

	@Override
	public List<Chambre> findByHotel(Integer nuhotel) {
		EntityManager em = getEntityManager();
		List<Chambre> list = null;
		try {
			em.getTransaction().begin();
			//why this one works also? because it's sql finally
			//String req = "select ch from Chambre ch WHERE nuhotel = :nuhotel ";
			String req = "select ch from Chambre ch INNER JOIN ch.hotel h WHERE h.nuhotel = :nuhotel ";
			list = em.createQuery(req, Chambre.class).setParameter("nuhotel", nuhotel).getResultList();
			em.getTransaction().commit();
		} catch(Exception e){
			em.getTransaction().rollback();
		}finally {
			closeEntityManager(em);
		}
		return list;
	}

	@Override
	public List<Chambre> findByHotelAndCategorie(Integer nuhotel, String categorie) {
		EntityManager em = getEntityManager();
		List<Chambre> list = null;
		try {
			em.getTransaction().begin();	
			String req = "SELECT ch FROM Chambre ch INNER JOIN ch.categorie c INNER JOIN ch.hotel h WHERE h.nuhotel = :nuh AND c.nomcat = :cat ";
			list = em.createQuery(req, Chambre.class).setParameter("cat", categorie).setParameter("nuh", nuhotel).getResultList();
			em.getTransaction().commit();
		} catch(Exception e){
			em.getTransaction().rollback();
		}finally {
			closeEntityManager(em);
		}
		return list;
	}

}
