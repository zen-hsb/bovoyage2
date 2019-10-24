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
 * Servlet implementation class ModifierDestinationServlet1
 */
@WebServlet("/ModifierDestinationServlet1")
public class ModifierDestinationServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page="";
		String id = request.getParameter("id");
		Long identifiant = Long.parseLong(id);
		Destination destination = service.findById(identifiant);
		request.setAttribute("destination", destination);
		page = "/modifier-destination.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
