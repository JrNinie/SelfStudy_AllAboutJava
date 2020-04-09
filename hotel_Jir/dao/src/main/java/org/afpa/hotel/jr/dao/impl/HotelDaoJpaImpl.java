/**
 * 
 */
package org.afpa.hotel.jr.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.afpa.hotel.jr.dao.jpa.HotelDao;
import org.afpa.hotel.jr.model.entities.Hotel;

public class HotelDaoJpaImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDao {

	@Override
	public Class<Hotel> getClazz() {
		setClazz(Hotel.class);
		return Hotel.class;
	}

	@Override
	public List<Hotel> findByName(String nom) {
		EntityManager em = getEntityManager();
		List<Hotel> hotels = null;
		try {
			em.getTransaction().begin();
//			String req1 = "select h from Hotel h WHERE h.nomhotel = :nomhotel ";
//			hotels = em.createQuery(req1, Hotel.class).setParameter("nomhotel", nom).getResultList();
			String req2 = "select h from Hotel h WHERE h.nomhotel LIKE upper(:nomhotel) ";
			hotels = em.createQuery(req2, Hotel.class).setParameter("nomhotel", "%" + nom + "%").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return hotels;
	}

	@Override
	public List<Hotel> findByCodePostal(String code) {
		EntityManager em = getEntityManager();
		List<Hotel> hotels = null;
		try {
			em.getTransaction().begin();
			// problem: in db, cpcode is like "27190,0" (String), so replace "=" by "like"
			// String req1 = "select h from Hotel h WHERE h.cphotel = :cphotel ";
			String req1 = "select h from Hotel h WHERE h.cphotel LIKE :cphotel ";
			hotels = em.createQuery(req1, Hotel.class).setParameter("cphotel", code + "%").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return hotels;
	}

	@Override
	public List<Hotel> findByNuType(Integer type) {
		EntityManager em = getEntityManager();
		List<Hotel> hotels = null;
		try {
			em.getTransaction().begin();
			String req1 = "select h from Hotel h INNER JOIN h.typeHotel tp WHERE tp.nutype = :nutype ";
			hotels = em.createQuery(req1, Hotel.class).setParameter("nutype", type).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return hotels;
	}

	@Override
	public List<Hotel> findByType(String type) {
		EntityManager em = getEntityManager();
		List<Hotel> hotels = null;
		try {
			em.getTransaction().begin();
			String req1 = "select h from Hotel h INNER JOIN h.typeHotel tp WHERE tp.nomtype = :nomtype ";
			hotels = em.createQuery(req1, Hotel.class).setParameter("nomtype", type).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return hotels;
	}

	@Override
	public List<Hotel> findByVille(String ville) {
		EntityManager em = getEntityManager();
		List<Hotel> hotels = null;
		try {
			em.getTransaction().begin();
			String req1 = "select h from Hotel h WHERE h.villehotel LIKE upper(:villehotel) ";
			hotels = em.createQuery(req1, Hotel.class).setParameter("villehotel", ville + "%").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return hotels;
	}

	@Override
	public List<Hotel> findByNameCodePostalVilleType(String nom, String code, String ville, Integer nutype) {
		EntityManager em = getEntityManager();
		List<Hotel> hotels = null;
		try {
			em.getTransaction().begin();
			String req1 = "SELECT h FROM Hotel h INNER JOIN h.typeHotel tp WHERE h.nomhotel LIKE upper(:nomhotel) AND h.villehotel LIKE upper(:villehotel) AND h.cphotel = :cphotel AND tp.nutype = :nutype ";
			hotels = em.createQuery(req1, Hotel.class).setParameter("nomhotel", "%" + nom + "%")
					.setParameter("villehotel", ville + "%").setParameter("cphotel", code)
					.setParameter("nutype", nutype).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return hotels;
	}

	@Override
	public List<Hotel> findByNameCodePostalVilleType(String nom, String code, String ville, String type) {
		EntityManager em = getEntityManager();
		List<Hotel> hotels = null;
		try {
			em.getTransaction().begin();
			String req1 = "SELECT h FROM Hotel h INNER JOIN h.typeHotel tp WHERE h.nomhotel LIKE upper(:nomhotel) AND h.villehotel LIKE upper(:villehotel) AND h.cphotel = :cphotel AND tp.nomtype = :nomtype ";
			hotels = em.createQuery(req1, Hotel.class).setParameter("nomhotel", "%" + nom + "%")
					.setParameter("villehotel", ville + "%").setParameter("cphotel", code).setParameter("nomtype", type)
					.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager(em);
		}
		return hotels;
	}

}
