/**
 * 
 */
package org.afpa.hotel.jr.dao.impl;

import javax.persistence.EntityManager;

import org.afpa.hotel.jr.dao.jpa.TypeHotelDao;
import org.afpa.hotel.jr.model.entities.TypeHotel;

public class TypeHotelDaoJpaImpl extends GenericDaoImpl<TypeHotel, Integer> implements TypeHotelDao {

	@Override
	public Class<TypeHotel> getClazz() {
		setClazz(TypeHotel.class);
		return TypeHotel.class;
	}

	@Override
	public TypeHotel findByNomtype(String nomtype) {
		EntityManager em = getEntityManager();
		TypeHotel typeHotel = null;
		try {
			em.getTransaction().begin();
			String req = "select th from TypeHotel th WHERE th.nomtype = :nomtype ";
			typeHotel = em.createQuery(req, TypeHotel.class).setParameter("nomtype", nomtype).getSingleResult();
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
		}
		finally {
			closeEntityManager(em);
		}
		return typeHotel;
	}
	

	


}
