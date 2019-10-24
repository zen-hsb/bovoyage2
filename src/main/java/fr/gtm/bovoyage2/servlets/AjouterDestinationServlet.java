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
 * Servlet implementation class AjouterDestinationServlet
 */
@WebServlet("/AjouterDestinationServlet")
public class AjouterDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page="";
		String region = request.getParameter("region");
		String description = request.getParameter("description");
		
		if(region==null || region.isEmpty() || description==null || description.isEmpty()) {
			page ="/show-destinations.jsp";
		} else {
			Destination destination = new Destination();
			destination.setRegion(region);
			destination.setDescription(description);
			service.create(destination);
			region=null;
			description=null;
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
