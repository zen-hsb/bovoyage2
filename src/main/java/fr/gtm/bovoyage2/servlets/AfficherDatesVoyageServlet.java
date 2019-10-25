package fr.gtm.bovoyage2.servlets;

import java.io.IOException;
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
import fr.gtm.bovoyage2.services.DestinationService;


@WebServlet("/AfficherDatesVoyageServlet")
public class AfficherDatesVoyageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
		

		List<Destination> destinations = service.getAllDestinations();
		request.setAttribute("destinations", destinations);
		
		page = "/show-datesVoyage.jsp";
		
		
		
		
		
		
		
//		Long id = Long.valueOf(request.getParameter("id"));
//		Set<DatesVoyage> datesVoyages = (Set<DatesVoyage>)service.getDatesVoyageById(id);		//service.getAllDatesVoyage();
//		Destination destinations = service.findById(id);
		
//		List<Destination> destinations = service.getAllDestinations();
//		request.setAttribute("destinations", destinations);
//		request.setAttribute("dates_voyages", datesVoyages);
		
//		page = "/show-datesVoyage.jsp";
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
