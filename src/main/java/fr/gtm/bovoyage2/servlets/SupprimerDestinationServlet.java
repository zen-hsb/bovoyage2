package fr.gtm.bovoyage2.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.bovoyage2.entities.DatesVoyage;
import fr.gtm.bovoyage2.services.DatesVoyageService;
import fr.gtm.bovoyage2.services.DestinationService;

/**
 * Servlet implementation class SupprimerDestinationServlet
 */
@WebServlet("/SupprimerDestinationServlet")
public class SupprimerDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		//DatesVoyageService dvservice = (DatesVoyageService) getServletContext().getAttribute(Constantes.DATESVOYAGE_SERVICE);
		
		String page="";
		String id = request.getParameter("id");
		//long identifiant = Long.valueOf(id);
		//Set<DatesVoyage> datesvoyages = service.getDatesVoyageByDestinationId(identifiant);
		//dvservice.delete(id);
		service.delete(id);
		page = "/AfficherDestinationServlet";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
