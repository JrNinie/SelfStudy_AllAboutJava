package org.afpa.hotel.jr.web.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afpa.hotel.jr.services.utils.HotelConstantes;
import org.afpa.hotel.jr.web.commandes.Commande;
import org.afpa.hotel.jr.web.commandes.CommandeInconnue;
import org.afpa.hotel.jr.web.exceptions.CommandeCreationException;



/**
 * Servlet implementation class Servlet2
 */

@WebServlet(name = "/indexServlet", urlPatterns = "*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("NomServlet '" + getServletName() + "'" + " methode " + request.getMethod() + " uri ["
				+ request.getRequestURI() + "]");
		
		//org.afpa.hotel.jr.web.commandes.Commande+nomaction => identifier la class Commande à utiliser
		String cmdClass = HotelConstantes.CMDPACKAGE + HotelConstantes.CMD + request.getParameter(HotelConstantes.CMDPARAM);
		System.out.println(cmdClass);
		
		
		Commande command = getCommand(request);
		String view = command.execute(request, response);
		System.out.println("view  [" + view + "]");
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.split("redirect:")[1]);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(HotelConstantes.JSPROOT + view + ".jsp");
			dispatcher.forward(request, response);
		}
	}

	private Commande getCommand(HttpServletRequest request) {
		//recevoir l'action envoyée depuis jsp
		String action = request.getParameter(HotelConstantes.CMDPARAM);
		//avoir la classe commande correspondante
		Class<?> commandClass = getCommandClass(action);
		try {
			return (Commande) commandClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			throw new CommandeCreationException("Command class '" + commandClass
					+ "' inconnu . Verifiez le parametre de votre request the request parameter", e);
		}
	}

	private static Class<?> getCommandClass(String commandAction) {
		//System.out.println("getcommandclass:" + HotelConstantes.CMDPACKAGE + HotelConstantes.CMD + commandAction);
		Class<?> loadedClass;
		try {
			//pour identifier/chercher la classe
			loadedClass = Class.forName(HotelConstantes.CMDPACKAGE + HotelConstantes.CMD + commandAction);
			//System.out.println("loadedClass.getCanonicalName: " + loadedClass.getCanonicalName());
		} catch (ClassNotFoundException e) {
			//si la classe cherchée n'existe pas, aller sur la classe 404
			loadedClass = CommandeInconnue.class;
		}
		return loadedClass;
	}

}