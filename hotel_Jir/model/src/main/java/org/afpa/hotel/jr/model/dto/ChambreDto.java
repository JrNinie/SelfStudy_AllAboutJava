package org.afpa.hotel.jr.model.dto;

import java.io.Serializable;
import javax.persistence.*;


public class ChambreDto implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer idChambre;
	private int nuchambre;
	private CategorieDto categorie;

	private HotelDto hotel;

	public ChambreDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChambreDto(int nuchambre, CategorieDto categorie, HotelDto hotel) {
		super();
		this.nuchambre = nuchambre;
		this.categorie = categorie;
		this.hotel = hotel;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idChambre == null) ? 0 : idChambre.hashCode());
		result = prime * result + nuchambre;
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
		ChambreDto other = (ChambreDto) obj;
		if (idChambre == null) {
			if (other.idChambre != null)
				return false;
		} else if (!idChambre.equals(other.idChambre))
			return false;
		if (nuchambre != other.nuchambre)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChambreDto [idChambre=" + idChambre + ", nuchambre=" + nuchambre + ", categorie=" + categorie + ", hotel="
				+ hotel + "]";
	}

	public Integer getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(Integer idChambre) {
		this.idChambre = idChambre;
	}

	public int getNuchambre() {
		return nuchambre;
	}

	public void setNuchambre(int nuchambre) {
		this.nuchambre = nuchambre;
	}

	public CategorieDto getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieDto categorie) {
		this.categorie = categorie;
	}

	public HotelDto getHotel() {
		return hotel;
	}

	public void setHotel(HotelDto hotel) {
		this.hotel = hotel;
	}





}