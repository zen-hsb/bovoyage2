package fr.gtm.bovoyage2.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.bovoyage2.entities.Destination;
import fr.gtm.bovoyage2.services.DestinationService;

/**
 * Servlet implementation class ModifierDestinationServlet2
 */
@WebServlet("/ModifierDestinationServlet2")
public class ModifierDestinationServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page="";
		String id = request.getParameter("id");
		Long identifiant = Long.parseLong(id);
		String region = request.getParameter("region");
		String description = request.getParameter("description");
		
		if(region==null || region.isEmpty() || description==null || description.isEmpty()) {
			page ="/show-destinations.jsp";
		} else {
			Destination destination = service.findById(identifiant);
			destination.setRegion(region);
			destination.setDescription(description);
			service.update(destination);
			page="/AfficherDestinationServlet";
		}
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
