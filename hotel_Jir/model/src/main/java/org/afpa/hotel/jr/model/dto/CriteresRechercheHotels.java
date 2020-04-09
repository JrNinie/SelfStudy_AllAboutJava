package org.afpa.hotel.jr.model.dto;

public class CriteresRechercheHotels {

	public static final String NUHOTEL="nuhotel";
	public static final String ADRESSEHOTEL="adressehotel";
	public static final String CPHOTEL="cphotel";
	public static final String NOMHOTEL= "nomhotel";
	public static final String VILLEHOTEL="villehotel";
	public static final String TYPEHOTEL="typeHotel";
	public static final String NUTYPEHOTEL= "nuTypeHotel";

	private Integer nuhotel;
	private String adressehotel;
	private String cphotel;
	private String nomhotel;
	private String villehotel;
	private String typeHotel;
	private String nuTypeHotel;

	public CriteresRechercheHotels(Integer nuhotel, String adressehotel, String cphotel, String nomhotel,
			String villehotel, String typeHotel, String nuTypeHotel) {
		this.nuhotel = nuhotel;
		this.adressehotel = adressehotel;
		this.cphotel = cphotel;
		this.nomhotel = nomhotel;
		this.villehotel = villehotel;
		this.typeHotel = typeHotel;
		this.nuTypeHotel = nuTypeHotel;
	}
	
	public Boolean isEmpty() {
		if (    nuhotel != null || // et empty ??
				adressehotel != null && !adressehotel.isEmpty() ||
				cphotel != null && !cphotel.isEmpty() ||
				nomhotel != null && !nomhotel.isEmpty() ||
				villehotel != null && !villehotel.isEmpty() ||
				typeHotel != null && !typeHotel.isEmpty() ||
				nuTypeHotel != null && !nuTypeHotel.isEmpty() 
				) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "CriteresRechercheHotels [nuhotel=" + nuhotel + ", adressehotel=" + adressehotel + ", cphotel=" + cphotel
				+ ", nomhotel=" + nomhotel + ", villehotel=" + villehotel + ", typeHotel=" + typeHotel
				+ ", nuTypeHotel=" + nuTypeHotel + "]";
	}

	public Integer getNuhotel() {
		return nuhotel;
	}

	public void setNuhotel(Integer nuhotel) {
		this.nuhotel = nuhotel;
	}

	public String getAdressehotel() {
		return adressehotel;
	}

	public void setAdressehotel(String adressehotel) {
		this.adressehotel = adressehotel;
	}

	public String getCphotel() {
		return cphotel;
	}

	public void setCphotel(String cphotel) {
		this.cphotel = cphotel;
	}

	public String getNomhotel() {
		return nomhotel;
	}

	public void setNomhotel(String nomhotel) {
		this.nomhotel = nomhotel;
	}

	public String getVillehotel() {
		return villehotel;
	}

	public void setVillehotel(String villehotel) {
		this.villehotel = villehotel;
	}

	public String getTypeHotel() {
		return typeHotel;
	}

	public void setTypeHotel(String typeHotel) {
		this.typeHotel = typeHotel;
	}

	public String getNuTypeHotel() {
		return nuTypeHotel;
	}

	public void setNuTypeHotel(String nuTypeHotel) {
		this.nuTypeHotel = nuTypeHotel;
	}

}
