package org.afpa.hotel.jr.services.utils;

import org.afpa.hotel.jr.dao.impl.CategorieDaoJpaImpl;
import org.afpa.hotel.jr.dao.impl.ChambreDaoJpaImpl;
import org.afpa.hotel.jr.dao.impl.HotelDaoJpaImpl;
import org.afpa.hotel.jr.dao.impl.TypeHotelDaoJpaImpl;
import org.afpa.hotel.jr.dao.jpa.CategorieDao;
import org.afpa.hotel.jr.dao.jpa.ChambreDao;
import org.afpa.hotel.jr.dao.jpa.HotelDao;
import org.afpa.hotel.jr.dao.jpa.TypeHotelDao;

public class DAOFactoryJPA implements DAOFactory {
	
	private static DAOFactoryJPA INSTANCE = new DAOFactoryJPA();
	
	ChambreDao chambreDao = new ChambreDaoJpaImpl();
	HotelDao hotelDao = new HotelDaoJpaImpl();
	CategorieDao categorieDao = new CategorieDaoJpaImpl();
	TypeHotelDao typeHotelDao = new TypeHotelDaoJpaImpl();
	
	public static DAOFactoryJPA getINSTANCE() {
		return INSTANCE;
	}
	
	private DAOFactoryJPA() {
	}
	
	public ChambreDao getChambreDao() {
		return chambreDao;
	}
	
	public HotelDao getHotelDao() {
		return hotelDao;
	}
	
	public CategorieDao getCategorieDao() {
		return categorieDao;
	}
	
	public TypeHotelDao getTypeHotelDao() {
		return typeHotelDao;
	}

}
