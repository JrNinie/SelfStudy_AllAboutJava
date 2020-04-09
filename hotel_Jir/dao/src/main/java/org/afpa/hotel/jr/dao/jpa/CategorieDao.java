package org.afpa.hotel.jr.dao.jpa;

import org.afpa.hotel.jr.model.entities.Categorie;

public interface CategorieDao extends DAO<Categorie, Integer> {

	public Categorie findByNomcat(String nomcat);
	public int deleteByNomcat(String nomcat);
}
