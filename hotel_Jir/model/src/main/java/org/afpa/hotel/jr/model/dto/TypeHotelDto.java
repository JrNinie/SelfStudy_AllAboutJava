package org.afpa.hotel.jr.model.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


public class TypeHotelDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer nutype;
	private String nomtype;
	
	//private List<HotelDto> hotels; NON pas necessaire dans les DTO ! va même foutre le bordel !

	public TypeHotelDto() {
	}

	public TypeHotelDto(Integer nutype, String nomtype) {
		super();
		this.nutype = nutype;
		this.nomtype = nomtype;
	}

	public Integer getNutype() {
		return this.nutype;
	}

	public void setNutype(Integer nutype) {
		this.nutype = nutype;
	}

	public String getNomtype() {
		return this.nomtype;
	}

	public void setNomtype(String nomtype) {
		this.nomtype = nomtype;
	}

//	public List<HotelDto> getHotels() {
//		return this.hotels;
//	}
//
//	public void setHotels(List<HotelDto> hotels) {
//		this.hotels = hotels;
//	}

//	public HotelDto addHotel(HotelDto hotel) {
//		getHotels().add(hotel);
//		hotel.setTypeHotel(this);
//
//		return hotel;
//	}
//
//	public HotelDto removeHotel(HotelDto hotel) {
//		getHotels().remove(hotel);
//		hotel.setTypeHotel(null);
//
//		return hotel;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomtype == null) ? 0 : nomtype.hashCode());
		result = prime * result + ((nutype == null) ? 0 : nutype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeHotelDto other = (TypeHotelDto) obj;
		if (nomtype == null) {
			if (other.nomtype != null)
				return false;
		} else if (!nomtype.equals(other.nomtype))
			return false;
		if (nutype == null) {
			if (other.nutype != null)
				return false;
		} else if (!nutype.equals(other.nutype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TypeHotelDto [nutype=" + nutype + ", nomtype=" + nomtype + "]";
	}

}