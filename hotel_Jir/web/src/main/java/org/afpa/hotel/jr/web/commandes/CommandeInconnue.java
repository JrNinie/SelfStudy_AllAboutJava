package org.afpa.hotel.jr.web.commandes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandeInconnue implements Commande {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "erreur404";
	}

}
