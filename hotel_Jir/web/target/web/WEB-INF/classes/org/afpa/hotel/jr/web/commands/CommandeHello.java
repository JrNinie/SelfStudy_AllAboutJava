/**
 * 
 */
package org.afpasigfox.hotel.commande;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author misstizia
 *
 */
public class CommandeHello  implements Commande  {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("hello");
		
		// => on veut la page hello.jsp
		return "hello";
	}

}
