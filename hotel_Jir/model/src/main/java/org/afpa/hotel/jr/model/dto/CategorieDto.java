package org.afpa.hotel.jr.model.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

public class CategorieDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer nucat;
	private String nomcat;

	// private List<ChambreDto> chambres; NON pas necessaire dans les DTO ! va même foutre le bordel !

	public CategorieDto() {
	}

	public CategorieDto(Integer nucat, String nomcat) {
		super();
		this.nucat = nucat;
		this.nomcat = nomcat;
	}

	public Integer getNucat() {
		return this.nucat;
	}

	public void setNucat(Integer nucat) {
		this.nucat = nucat;
	}

	public String getNomcat() {
		return this.nomcat;
	}

	public void setNomcat(String nomcat) {
		this.nomcat = nomcat;
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
//		chambre.setCategorie(this);
//
//		return chambre;
//	}
//
//	public ChambreDto removeChambre(ChambreDto chambre) {
//		getChambres().remove(chambre);
//		chambre.setCategorie(null);
//
//		return chambre;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomcat == null) ? 0 : nomcat.hashCode());
		result = prime * result + ((nucat == null) ? 0 : nucat.hashCode());
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
		CategorieDto other = (CategorieDto) obj;
		if (nomcat == null) {
			if (other.nomcat != null)
				return false;
		} else if (!nomcat.equals(other.nomcat))
			return false;
		if (nucat == null) {
			if (other.nucat != null)
				return false;
		} else if (!nucat.equals(other.nucat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategorieDto [nucat=" + nucat + ", nomcat=" + nomcat + "]";
	}



}