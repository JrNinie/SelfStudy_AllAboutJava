package org.afpa.hotel.jr.services.utils;

import org.afpa.hotel.jr.dao.jpa.CategorieDao;
import org.afpa.hotel.jr.dao.jpa.ChambreDao;
import org.afpa.hotel.jr.dao.jpa.HotelDao;
import org.afpa.hotel.jr.dao.jpa.TypeHotelDao;

public interface DAOFactory {
	
	enum FactoryType{
		JDBC,JPA,HIBERNATE
	}
	
	public static DAOFactory getFactoryDao(FactoryType quelType) {
		switch(quelType) {
			case JPA:
				return DAOFactoryJPA.getINSTANCE();
			case JDBC:
				throw new IllegalArgumentException("FactoryDaoJDBC en cours d'élaboration");
			case HIBERNATE:
				throw new IllegalArgumentException("FactoryDaoHibernate est prévu dans la version supérieure");
			default:
				throw new IllegalArgumentException("FactoryDao... non prévu actuellement");
			
		}
	}
	public HotelDao getHotelDao();
	public ChambreDao getChambreDao();
	public CategorieDao getCategorieDao();
	public TypeHotelDao getTypeHotelDao();
}
