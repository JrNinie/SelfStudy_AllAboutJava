/**
 * 
 */
package org.afpasigfox.hotel.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afpasigfox.hotel.dto.ChambreDto;
import org.afpasigfox.hotel.dto.HotelDto;
import org.afpasigfox.hotel.dto.Page;
import org.afpasigfox.hotel.services.IServiceChambre;
import org.afpasigfox.hotel.services.IServiceHotel;

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
