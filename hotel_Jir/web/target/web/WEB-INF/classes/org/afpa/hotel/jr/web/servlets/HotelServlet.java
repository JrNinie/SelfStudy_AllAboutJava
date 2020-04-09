package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Filtre;
import model.Collectionneur;
import model.DAOFactory;
import model.GetFilterInRequest;
import model.beans.HotelType;
import model.beans.RoomCategory;

/**
 * Servlet implementation class HotelServlet
 */
@WebServlet("/hotels") ///  arrrrggggg ! ça marche pas !!!!! ==> projet maven donc dans dossier java, et pas dans ressources
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		GetFilterInRequest getFilter = new GetFilterInRequest();
		// #### HotelType ####	  	
	  	getFilter.getHotelTypeFilter(request);
		// et ajoute ce filtre comme attribut à la request (TODO : le mettre plutot dans la session... ou pas ?)
		request.setAttribute("filtreHotelType", getFilter.getFiltreHotelType());
		
		// ### RoomCategory ###	  	
	  	getFilter.getRoomCategoryFilter(request);
		// et ajoute ce filtre comme attribut à la request (TODO : le mettre plutot dans la session... ou pas ?)
		request.setAttribute("filtreRoomCategory", getFilter.getFiltreRoomCategory());
		
		// ### dispatch ###
		this.getServletContext().getRequestDispatcher("/WEB-INF/hotels.jsp").forward(request, response);
		
		// #### testing ####
		// add un objet à la session
		//request.getSession().setAttribute("text2", new HotelType(999, "toto"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
