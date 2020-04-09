/**
 * 
 */
package org.afpa.hotel.jr.services.jpa;

import java.util.List;

import org.afpa.hotel.jr.dao.jpa.ChambreDao;
import org.afpa.hotel.jr.model.dto.ChambreDto;
import org.afpa.hotel.jr.model.dto.Page;
import org.afpa.hotel.jr.model.entities.Chambre;
import org.afpa.hotel.jr.services.utils.DAOFactory;
import org.afpa.hotel.jr.services.utils.Mapper;

/**
 * @author misstizia
 *
 */
public class ServiceChambreJPAImpl implements IServiceChambre {
	
	DAOFactory jpaFactory=DAOFactory.getFactoryDao(DAOFactory.FactoryType.JPA);
	ChambreDao chambreDao = jpaFactory.getChambreDao();

	@Override
	public Page<ChambreDto> rechercheChambre(int nuhotel) {
		List<Chambre> listChambreEntity= chambreDao.findByHotel(nuhotel);
		List<ChambreDto> listChambreDto = Mapper.map(listChambreEntity, ChambreDto.class);		
		return new Page<ChambreDto>(listChambreDto);
	}

}
