package fr.gtm.bovoyage2.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.bovoyage2.entities.DatesVoyage;
import fr.gtm.bovoyage2.entities.Destination;
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
		String page="";
		String id = request.getParameter("id");
		Long identifiant = Long.valueOf(id);
		Set<DatesVoyage> datesvoyages = service.getDatesVoyageByDestinationId(identifiant);
		DatesVoyage date = new DatesVoyage();
		
		Iterator<DatesVoyage> it = datesvoyages.iterator();
		while(it.hasNext()) {
			date = it.next();
			service.deleteDatesVoyage(date.getId());
			it.remove();
		}

		service.findById(identifiant).setDatesVoyage(datesvoyages);
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
