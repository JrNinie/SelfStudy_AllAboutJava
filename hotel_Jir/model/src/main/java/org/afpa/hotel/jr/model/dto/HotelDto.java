package org.afpa.hotel.jr.model.dto;

import java.io.Serializable;
import java.util.List;

public class HotelDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer nuhotel;
	private String adressehotel;
	private String cphotel;
	private String nomhotel;
	private String villehotel;
	//private List<ChambreDto> chambres;
	private TypeHotelDto typeHotel;
	
	public HotelDto(String adressehotel, String cphotel, String nomhotel, String villehotel, 
			//List<ChambreDto> chambres,
			TypeHotelDto typeHotel) {
		this.adressehotel = adressehotel;
		this.cphotel = cphotel;
		this.nomhotel = nomhotel;
		this.villehotel = villehotel;
		//this.chambres = chambres;
		this.typeHotel = typeHotel;
	}

	public HotelDto() {
	}

	public Integer getNuhotel() {
		return this.nuhotel;
	}

	public void setNuhotel(Integer nuhotel) {
		this.nuhotel = nuhotel;
	}

	public String getAdressehotel() {
		return this.adressehotel;
	}

	public void setAdressehotel(String adressehotel) {
		this.adressehotel = adressehotel;
	}

	public String getCphotel() {
		return this.cphotel;
	}

	public void setCphotel(String cphotel) {
		this.cphotel = cphotel;
	}

	public String getNomhotel() {
		return this.nomhotel;
	}

	public void setNomhotel(String nomhotel) {
		this.nomhotel = nomhotel;
	}

	public String getVillehotel() {
		return this.villehotel;
	}

	public void setVillehotel(String villehotel) {
		this.villehotel = villehotel;
	}

//	public List<ChambreDto> getChambres() {
//		return this.chambres;
//	}
//
//	public void setChambres(List<ChambreDto> chambres) {
//		this.chambres = chambres;
//	}

//	public ChambreDto addChambre(ChambreDto chambre) {
//		getChambres().add(chambre);
//		chambre.setHotel(this);
//
//		return chambre;
//	}
//
//	public ChambreDto removeChambre(ChambreDto chambre) {
//		getChambres().remove(chambre);
//		chambre.setHotel(null);
//		return chambre;
//	}

	public TypeHotelDto getTypeHotel() {
		return this.typeHotel;
	}

	public void setTypeHotel(TypeHotelDto typeHotel) {
		this.typeHotel = typeHotel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressehotel == null) ? 0 : adressehotel.hashCode());
		result = prime * result + ((cphotel == null) ? 0 : cphotel.hashCode());
		result = prime * result + ((nomhotel == null) ? 0 : nomhotel.hashCode());
		result = prime * result + ((nuhotel == null) ? 0 : nuhotel.hashCode());
		result = prime * result + ((typeHotel == null) ? 0 : typeHotel.hashCode());
		result = prime * result + ((villehotel == null) ? 0 : villehotel.hashCode());
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
		HotelDto other = (HotelDto) obj;
		if (adressehotel == null) {
			if (other.adressehotel != null)
				return false;
		} else if (!adressehotel.equals(other.adressehotel))
			return false;
		if (cphotel == null) {
			if (other.cphotel != null)
				return false;
		} else if (!cphotel.equals(other.cphotel))
			return false;
		if (nomhotel == null) {
			if (other.nomhotel != null)
				return false;
		} else if (!nomhotel.equals(other.nomhotel))
			return false;
		if (nuhotel == null) {
			if (other.nuhotel != null)
				return false;
		} else if (!nuhotel.equals(other.nuhotel))
			return false;
		if (typeHotel == null) {
			if (other.typeHotel != null)
				return false;
		} else if (!typeHotel.equals(other.typeHotel))
			return false;
		if (villehotel == null) {
			if (other.villehotel != null)
				return false;
		} else if (!villehotel.equals(other.villehotel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HotelDto [nuhotel=" + nuhotel + ", adressehotel=" + adressehotel + ", cphotel=" + cphotel + ", nomhotel="
				+ nomhotel + ", villehotel=" + villehotel + ", typeHotel=" + typeHotel + "]";
	}

}
