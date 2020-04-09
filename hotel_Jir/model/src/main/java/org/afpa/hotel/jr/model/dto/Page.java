package org.afpa.hotel.jr.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	int nbElementsParPage = 10;
	int nbPages = 0;
	int numeroPageEnCours = -1;
	int nbTotalElements = 0;
	
	List<T> pageElements = new ArrayList<T>();
	
	public Page() {
		// none
	}
	
	public Page(List<T> pageElements) {
		this.pageElements = pageElements;
	}

	public Page(int nbElementsParPage, int numeroPageEnCours, int nbTotalElements, List<T> pageElements) {
		this.nbElementsParPage = nbElementsParPage;
		this.nbTotalElements = nbTotalElements;
		this.pageElements = pageElements;
		this.numeroPageEnCours = numeroPageEnCours;
		if ( (nbTotalElements / nbElementsParPage) % 2 == 0)
			this.nbPages = nbTotalElements / nbElementsParPage;
		else {
			this.nbPages = nbTotalElements / nbElementsParPage + 1;
		}
//		BUGFIX : this version is not good !
//		if (nbTotalElements % 2 == 0)
//			this.nbPages = nbTotalElements / nbElementsParPage;
//		else {
//			this.nbPages = nbTotalElements / nbElementsParPage + 1;
//		}
	}

	public int getNbElementsParPage() {
		return nbElementsParPage;
	}

	public void setNbElementsParPage(int nbElementsParPage) {
		this.nbElementsParPage = nbElementsParPage;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	public int getNumeroPageEnCours() {
		return numeroPageEnCours;
	}

	public void setNumeroPageEnCours(int numeroPageEnCours) {
		this.numeroPageEnCours = numeroPageEnCours;
	}

	public int getNbTotalElements() {
		return nbTotalElements;
	}

	public void setNbTotalElements(int nbTotalElements) {
		this.nbTotalElements = nbTotalElements;
	}

	public List<T> getPageElements() {
		return pageElements;
	}

	public void setPageElements(List<T> pageElements) {
		this.pageElements = pageElements;
	}
	
	@Override
	public String toString() {
		return "Page [nbElementsParPage=" + nbElementsParPage + ", nbPages=" + nbPages + ", numeroPageEnCours="
				+ numeroPageEnCours + ", nbTotalElements=" + nbTotalElements + ", pageElements=" + pageElements + "]";
	}

}
