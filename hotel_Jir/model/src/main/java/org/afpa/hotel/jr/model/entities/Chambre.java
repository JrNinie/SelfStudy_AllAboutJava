package org.afpa.hotel.jr.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the chambre database table.
 */
@Entity
@NamedQuery(name="Chambre.findAll", query="SELECT c FROM Chambre c")
public class Chambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idchambre;

	private Integer nuchambre;

	//bi-directional many-to-one association to Categorie
	//On charge directement la categorie
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="nucatchambre")
	private Categorie categorie;

	
	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="nuhotel")
	private Hotel hotel;

	public Chambre() {
	}
	
	public Chambre(Categorie categorie, Hotel hotel) {
		super();
		this.categorie = categorie;
		this.hotel = hotel;
	}

	
	

	public Integer getIdchambre() {
		return this.idchambre;
	}

	public void setIdchambre(Integer idchambre) {
		this.idchambre = idchambre;
	}

	public Integer getNuchambre() {
		return this.nuchambre;
	}

	public void setNuchambre(Integer nuchambre) {
		this.nuchambre = nuchambre;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idchambre == null) ? 0 : idchambre.hashCode());
		result = prime * result + ((nuchambre == null) ? 0 : nuchambre.hashCode());
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
		Chambre other = (Chambre) obj;
		if (idchambre == null) {
			if (other.idchambre != null)
				return false;
		} else if (!idchambre.equals(other.idchambre))
			return false;
		if (nuchambre == null) {
			if (other.nuchambre != null)
				return false;
		} else if (!nuchambre.equals(other.nuchambre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chambre [idchambre=" + idchambre + ", nuchambre=" + nuchambre + ", categorie=" + categorie + ", hotel="
				+ hotel + "]";
	}

}