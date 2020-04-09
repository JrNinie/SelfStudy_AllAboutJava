package org.afpa.hotel.jr.dao.jpa;

import java.util.List;

import org.afpa.hotel.jr.model.entities.Chambre;

public interface ChambreDao extends DAO<Chambre, Integer>
{
	public List<Chambre> findByCategorie(String categorie);
	public List<Chambre> findByHotel(Integer nuhotel);
	public List<Chambre> findByHotelAndCategorie(Integer nuhotel,String categorie);

}
