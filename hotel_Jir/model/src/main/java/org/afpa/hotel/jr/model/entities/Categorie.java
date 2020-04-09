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


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -360465192246809198L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer nucat;

	private String nomcat;

	//bi-directional many-to-one association to Chambre
	@OneToMany(mappedBy="categorie", fetch = FetchType.LAZY)
	private List<Chambre> chambres;

	public Categorie() {
	}
	
	public Categorie(String nomcat) {
		this.nomcat= nomcat; 
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

	public List<Chambre> getChambres() {
		return this.chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public Chambre addChambre(Chambre chambre) {
		getChambres().add(chambre);
		chambre.setCategorie(this);

		return chambre;
	}

	public Chambre removeChambre(Chambre chambre) {
		getChambres().remove(chambre);
		chambre.setCategorie(null);

		return chambre;
	}

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
		Categorie other = (Categorie) obj;
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
		return "Categorie [nucat=" + nucat + ", nomcat=" + nomcat + "]";
	}
	

}