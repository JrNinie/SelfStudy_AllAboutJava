package org.afpa.hotel.jr.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the type_hotel database table.
 * 
 */
@Entity
@Table(name="type_hotel")
@NamedQuery(name="TypeHotel.findAll", query="SELECT t FROM TypeHotel t")
public class TypeHotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer nutype;

	private String nomtype;

	//bi-directional many-to-one association to Hotel
	@OneToMany(mappedBy="typeHotel", fetch = FetchType.LAZY)
	private List<Hotel> hotels;

	public TypeHotel() {
	}

	public TypeHotel(String nomtype) {
		super();
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

	public List<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel addHotel(Hotel hotel) {
		getHotels().add(hotel);
		hotel.setTypeHotel(this);

		return hotel;
	}

	public Hotel removeHotel(Hotel hotel) {
		getHotels().remove(hotel);
		hotel.setTypeHotel(null);

		return hotel;
	}

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
		TypeHotel other = (TypeHotel) obj;
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
		return "TypeHotel [nutype=" + nutype + ", nomtype=" + nomtype + "]";
	}

	

}