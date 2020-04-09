package org.afpasigfox.hotel.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetFilterInRequest;

public class CommandeChercherHotels implements Commande {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("ChercherHotels");
		
		GetFilterInRequest getFilter = new GetFilterInRequest();
		// #### HotelType ####	  	
	  	getFilter.getHotelTypeFilter(request);
		// et ajoute ce filtre comme attribut à la request (TODO : le mettre plutot dans la session... ou pas ?)
		request.setAttribute("filtreHotelType", getFilter.getFiltreHotelType());
		
		// ### RoomCategory ###	  	
	  	getFilter.getRoomCategoryFilter(request);
		// et ajoute ce filtre comme attribut à la request (TODO : le mettre plutot dans la session... ou pas ?)
		request.setAttribute("filtreRoomCategory", getFilter.getFiltreRoomCategory());
		
		return "lookingforhotels";
	}

}
