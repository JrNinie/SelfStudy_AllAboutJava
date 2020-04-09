/**
 * 
 */
package org.afpasigfox.hotel.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afpasigfox.hotel.dto.CriteresRechercheHotels;
import org.afpasigfox.hotel.dto.HotelDto;
import org.afpasigfox.hotel.dto.Page;
import org.afpasigfox.hotel.services.IServiceHotel;

/**
 * @author misstizia
 *
 */
public class CommandeChercherHotelPaginesJPA implements Commande {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
		
		int nbHotelParPage = 10; // donc 10 par defaut
		if (request.getParameter("nbhotelsparpage") != null) {
			nbHotelParPage = Integer.parseInt(request.getParameter("nbhotelsparpage"));
		} else if (request.getSession().getAttribute("nbHotelParPage") != null) {
			nbHotelParPage = (int) request.getSession().getAttribute("nbHotelParPage");			
		}
		
		int numeroPageEnCours = 0; // donc 0 par defaut
		if (request.getParameter("numeroPageEnCours") != null) {
			numeroPageEnCours = Integer.parseInt(request.getParameter("numeroPageEnCours"));
		} else if (request.getSession().getAttribute("numeroPageEnCours") != null) {
			numeroPageEnCours = (int) request.getSession().getAttribute("numeroPageEnCours");			
		}
		
		// for CRITERIA
		String nomHotel = null;
		if (request.getParameter("nomhotel") != null) {
			nomHotel = request.getParameter("nomhotel");
		} else if (request.getSession().getAttribute("nomhotel") != null) {
			nomHotel = (String) request.getSession().getAttribute("nomhotel");			
		}
		CriteresRechercheHotels criteresRechercheHotels = new CriteresRechercheHotels(
				null, null, null, nomHotel,	null, null, null);
		System.out.println("criteresRechercheHotels : " + criteresRechercheHotels);
		
		IServiceHotel sHotelJPA = IServiceHotel.getServiceHotel(IServiceHotel.ServiceType.JPA);
		
		Page<HotelDto> gestionnairePages = new Page<HotelDto>();
		if (criteresRechercheHotels.isEmpty()) {
			// sans criteres de recherche
			System.out.println("recherche SANS critère");
			gestionnairePages = sHotelJPA.recherchePageHotel(nbHotelParPage, numeroPageEnCours);
		} else {
			// avec critère de recherche
			System.out.println("recherche AVEC critère");
			gestionnairePages = sHotelJPA.recherchePageHotel(
					criteresRechercheHotels, nbHotelParPage, numeroPageEnCours);
		}		
		
		request.setAttribute("gestionnairePages", gestionnairePages);
		//request.setAttribute("gestionnairePagesCriteria", gestionnairePagesCriteria);
		request.getSession().setAttribute("nomhotel", nomHotel); // juste pour voir
		request.getSession().setAttribute("nbHotelParPage", nbHotelParPage);
		request.getSession().setAttribute("numeroPageEnCours", numeroPageEnCours);
		
		return "lookingforhotelspagines";
	}
	
	
	

}
