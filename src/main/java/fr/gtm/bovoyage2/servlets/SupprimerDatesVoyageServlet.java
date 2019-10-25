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
import fr.gtm.bovoyage2.entities.Destination;
import fr.gtm.bovoyage2.services.DestinationService;

/**
 * Servlet implementation class SupprimerDatesVoyageServlet
 */
@WebServlet("/SupprimerDatesVoyageServlet")
public class SupprimerDatesVoyageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
		
		Long id1 = Long.valueOf(request.getParameter("id1"));
		Long id2 = Long.valueOf(request.getParameter("id2"));
		
		service.deleteDatesVoyage(id1);
		
		Set<DatesVoyage> datesvoyages = (Set<DatesVoyage>)service.getDatesVoyageByDestinationId(id2);
		Destination destination = service.findById(id2);
		
		request.setAttribute("destination", destination);
		request.setAttribute("datesvoyages", datesvoyages);
		
		page="/show-datesvoyage.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
