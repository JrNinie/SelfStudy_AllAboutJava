package org.afpa.hotel.jr.services.jpa;

import java.util.List;

import org.afpa.hotel.jr.dao.jpa.HotelDao;
import org.afpa.hotel.jr.model.dto.CriteresRechercheHotels;
import org.afpa.hotel.jr.model.dto.HotelDto;
import org.afpa.hotel.jr.model.dto.Page;
import org.afpa.hotel.jr.model.entities.Hotel;
import org.afpa.hotel.jr.services.utils.DAOFactory;
import org.afpa.hotel.jr.services.utils.Mapper;

public class ServiceHotelJPAImpl implements IServiceHotel{
	
	DAOFactory jpaFactory=DAOFactory.getFactoryDao(DAOFactory.FactoryType.JPA);
	HotelDao hotelDao = jpaFactory.getHotelDao();
	
	@Override
	public Page<HotelDto> recherchePageHotel(int nbElementsParPage, int numeroPageEnCours) {
		List<Hotel> listHotelEntity= hotelDao.findAll(nbElementsParPage, numeroPageEnCours);
		int nbTotalElements = hotelDao.count();
		System.out.println("count : " + nbTotalElements);
		List<HotelDto> listHotelDto = Mapper.map(listHotelEntity, HotelDto.class);		
		return new Page<HotelDto>(nbElementsParPage, numeroPageEnCours, nbTotalElements, listHotelDto);
		// utiliser directemnt dans la jsp
	}
	
	@Override
	public Page<HotelDto> recherchePageHotel(
			CriteresRechercheHotels criteresRechercheHotels, 
			int nbElementsParPage,
			int numeroPageEnCours) {
//		System.out.println("firstResult : " + numeroPageEnCours * nbElementsParPage);
//		List<Hotel> listHotelEntity = hotelDao.findByNameCodePostalVilleType(
//				criteresRechercheHotels.getNomhotel(), 
//				criteresRechercheHotels.getCphotel(), 
//				criteresRechercheHotels.getVillehotel(),
//				criteresRechercheHotels.getTypeHotel(), 
//				nbElementsParPage, (numeroPageEnCours * nbElementsParPage) ); // maxResults, firstResult
//		
//		//int nbTotalElements = hotelDao.count(); // oui mais là en fait non !
//		//int nbTotalElements = listHotelEntity.size(); // ah ben non plus ! => tjours le nbElementsParPage
//		
//		// TODO : Il doit y avoir mieux !
//		int nbTotalElements = hotelDao.findByNameCodePostalVilleType(
//				criteresRechercheHotels.getNomhotel(), 
//				criteresRechercheHotels.getCphotel(), 
//				criteresRechercheHotels.getVillehotel(),
//				criteresRechercheHotels.getTypeHotel())
//				.size();
//		
//		List<HotelDto> listHotelDto = Mapper.map(listHotelEntity, HotelDto.class);
//		return new Page<HotelDto>(nbElementsParPage, numeroPageEnCours, nbTotalElements, listHotelDto);
		return null;
}
	
	public HotelDto afficheHotelDetail(int nuhotel) {
		Hotel hotel = hotelDao.findById(nuhotel);
		HotelDto hotelDto = Mapper.map(hotel, HotelDto.class);
		return hotelDto;
	}

}
