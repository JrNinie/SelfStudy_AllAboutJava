/**
 * 
 */
package org.afpa.hotel.jr.web.commandes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afpa.hotel.jr.model.dto.ChambreDto;
import org.afpa.hotel.jr.model.dto.HotelDto;
import org.afpa.hotel.jr.model.dto.Page;
import org.afpa.hotel.jr.services.jpa.IServiceChambre;
import org.afpa.hotel.jr.services.jpa.IServiceHotel;

/**
 * @author misstizia
 *
 */
public class CommandeAfficheDetailHotelJPA implements Commande {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int nuhotel = Integer.parseInt(request.getParameter("nuhotel"));
		
		IServiceHotel sHotelJPA = IServiceHotel.getServiceHotel(IServiceHotel.ServiceType.JPA);
		HotelDto hotel = sHotelJPA.afficheHotelDetail(nuhotel);		
		request.setAttribute("hotel", hotel);
		
		IServiceChambre sChambreJPA = IServiceChambre.getServiceChambre(IServiceChambre.ServiceType.JPA);
		Page<ChambreDto> chambres = sChambreJPA.rechercheChambre(nuhotel);		
		request.setAttribute("chambres", chambres);
		
		return "detailhotel";
	}

}
