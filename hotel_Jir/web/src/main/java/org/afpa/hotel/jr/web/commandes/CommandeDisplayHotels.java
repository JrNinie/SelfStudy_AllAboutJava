package org.afpa.hotel.jr.web.commandes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afpa.hotel.jr.dao.impl.CategorieDaoJpaImpl;
import org.afpa.hotel.jr.dao.impl.TypeHotelDaoJpaImpl;
import org.afpa.hotel.jr.dao.jpa.CategorieDao;
import org.afpa.hotel.jr.dao.jpa.TypeHotelDao;
import org.afpa.hotel.jr.model.entities.Categorie;
import org.afpa.hotel.jr.model.entities.TypeHotel;

public class CommandeDisplayHotels implements Commande {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "a test message ");
		
//		CategorieDao categorieDao = new CategorieDaoJpaImpl();
//		Categorie c = categorieDao.findById(2);
//		request.setAttribute("categorie", c);
		

		// avoir la list de catégorie
		CategorieDao categorieDao = new CategorieDaoJpaImpl();
		List<Categorie> listCategorie = categorieDao.findAll();
		request.setAttribute("listCategorie", listCategorie);

		// avoir la list de typehote
		TypeHotelDao typeHotelDao = new TypeHotelDaoJpaImpl();
		List<TypeHotel> listTypeHotel = typeHotelDao.findAll();
		request.setAttribute("listTypeHotel", listTypeHotel);

		
		// envoyer à la page hotels.jsp
		return "hotels";
	}

}
