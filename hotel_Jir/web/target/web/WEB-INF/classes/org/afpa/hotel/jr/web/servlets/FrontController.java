package org.afpasigfox.hotel.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afpasigfox.hotel.commande.Commande;
import org.afpasigfox.hotel.commande.CommandeInconnue;
import org.afpasigfox.hotel.exceptions.CommandeCreationException;
import org.afpasigfox.hotel.utils.HotelConstantes;

/**
 * Servlet implementation class Servlet2
 */

@WebServlet(name = "/indexServlet", urlPatterns = "*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("NomServlet '" + getServletName() + "'" + " methode " + request.getMethod() + " uri ["
				+ request.getRequestURI() + "]");
		String cmdClass = HotelConstantes.CMDPACKAGE + HotelConstantes.CMD + request.getParameter(HotelConstantes.CMDPARAM);
		System.out.println(cmdClass);
		
		// response.setContentType(HotelConstants.CONTENT_TYPE);
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

	private org.afpasigfox.hotel.commande.Commande getCommand(HttpServletRequest request) {
		String action = request.getParameter(HotelConstantes.CMDPARAM);
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
			loadedClass = Class.forName(HotelConstantes.CMDPACKAGE + HotelConstantes.CMD + commandAction);
			//System.out.println("loadedClass.getCanonicalName: " + loadedClass.getCanonicalName());
		} catch (ClassNotFoundException e) {
			loadedClass = CommandeInconnue.class;
		}
		return loadedClass;
	}

}
