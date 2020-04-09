/**
 * 
 */
package org.afpa.hotel.jr.services.jpa;

import org.afpa.hotel.jr.model.dto.ChambreDto;
import org.afpa.hotel.jr.model.dto.Page;


/**
 * @author misstizia
 *
 */
public interface IServiceChambre {
	
	enum ServiceType {
		JPA, JDBC
	}

	public static IServiceChambre getServiceChambre(ServiceType quelType) {
		switch (quelType) {
		case JPA:
			return new ServiceChambreJPAImpl();
		case JDBC:
			throw new IllegalArgumentException("ServiceHotelJDBC en cours d'elaboration");
		default:
			throw new IllegalArgumentException("ServiceHotel... non prevu actuallement");

		}
	}

	Page<ChambreDto> rechercheChambre(int nuhotel);

}
