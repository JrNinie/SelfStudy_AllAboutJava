package org.afpa.hotel.jr.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer nuhotel;

	private String adressehotel;

	private String cphotel;

	private String nomhotel;

	private String villehotel;

	//bi-directional many-to-one association to Chambre
	@OneToMany(mappedBy="hotel")
	private List<Chambre> chambres;

	//bi-directional many-to-one association to TypeHotel
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="nutypehotel")
	private TypeHotel typeHotel;

	public Hotel() {
	}

	public Hotel(String adressehotel, String cphotel, String nomhotel, String villehotel,
			TypeHotel typeHotel) {
		super();
		this.adressehotel = adressehotel;
		this.cphotel = cphotel;
		this.nomhotel = nomhotel;
		this.villehotel = villehotel;
		this.typeHotel = typeHotel;
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

	public List<Chambre> getChambres() {
		return this.chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public Chambre addChambre(Chambre chambre) {
		getChambres().add(chambre);
		chambre.setHotel(this);

		return chambre;
	}

	public Chambre removeChambre(Chambre chambre) {
		getChambres().remove(chambre);
		chambre.setHotel(null);

		return chambre;
	}

	public TypeHotel getTypeHotel() {
		return this.typeHotel;
	}

	public void setTypeHotel(TypeHotel typeHotel) {
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
		Hotel other = (Hotel) obj;
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
		if (villehotel == null) {
			if (other.villehotel != null)
				return false;
		} else if (!villehotel.equals(other.villehotel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hotel [nuhotel=" + nuhotel + ", adressehotel=" + adressehotel + ", cphotel=" + cphotel + ", nomhotel="
				+ nomhotel + ", villehotel=" + villehotel + ", typeHotel=" + typeHotel + "]";
	}


}