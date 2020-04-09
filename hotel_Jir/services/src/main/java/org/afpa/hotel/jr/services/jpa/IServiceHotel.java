package org.afpa.hotel.jr.services.jpa;

import org.afpa.hotel.jr.model.dto.CriteresRechercheHotels;
import org.afpa.hotel.jr.model.dto.HotelDto;
import org.afpa.hotel.jr.model.dto.Page;

public interface IServiceHotel {

	enum ServiceType {
		JPA, JDBC
	}

	public static IServiceHotel getServiceHotel(ServiceType quelType) {
		switch (quelType) {
		case JPA:
			return new ServiceHotelJPAImpl();
		case JDBC:
			throw new IllegalArgumentException("ServiceHotelJDBC en cours d'elaboration");
		default:
			throw new IllegalArgumentException("ServiceHotel... non prevu actuallement");

		}
	}

	Page<HotelDto> recherchePageHotel(int maxResults, int firstResult);
	Page<HotelDto> recherchePageHotel(CriteresRechercheHotels criteresRechercheHotels,int maxResults, int firstResult);
	
	HotelDto afficheHotelDetail(int nuhotel);

}
