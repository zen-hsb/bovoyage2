package fr.gtm.bovoyage2.servlets;

import java.io.IOException;
import java.util.Iterator;
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
 * Servlet implementation class ModifierDatesVoyageServlet1
 */
@WebServlet("/ModifierDatesVoyageServlet1")
public class ModifierDatesVoyageServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page="";
		
		Long id1 = Long.valueOf(request.getParameter("id1"));
		Long id2 = Long.valueOf(request.getParameter("id2"));
		Destination destination = service.findById(id2);
		Set<DatesVoyage> datesvoyage = service.getDatesVoyageByDestinationId(id2);
		DatesVoyage date = new DatesVoyage();
		DatesVoyage datesvoyages = new DatesVoyage();
		
		Iterator<DatesVoyage> it = datesvoyage.iterator();
		while (it.hasNext()) {
			date = it.next();
			if(date.getId()==id1) {
				datesvoyages = date;
			}
		}
		
		request.setAttribute("destination", destination);
		request.setAttribute("datesvoyages", datesvoyages);
		
		page = "/modifier-datesvoyage.jsp";
		
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
