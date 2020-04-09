package org.afpa.hotel.jr.dao.jpa;

import org.afpa.hotel.jr.model.entities.TypeHotel;

public interface TypeHotelDao extends DAO<TypeHotel, Integer> {

	public TypeHotel findByNomtype(String nomtype);
}
