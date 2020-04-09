package org.afpa.hotel.jr.dao.jpa;

import java.util.List;

import org.afpa.hotel.jr.model.entities.Hotel;

public interface HotelDao extends DAO<Hotel, Integer>{
	public List<Hotel> findByName(String nom);
	public List<Hotel> findByCodePostal(String code);
	public List<Hotel> findByNuType(Integer type);
	public List<Hotel> findByType(String type);
	public List<Hotel> findByVille(String ville);
	public List<Hotel> findByNameCodePostalVilleType(String nom,String code,String ville,Integer nutype);
	public List<Hotel> findByNameCodePostalVilleType(String nom,String code,String ville,String type);
}
