package fr.gtm.bovoyage2.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class ModifierDatesVoyageServlet2
 */
@WebServlet("/ModifierDatesVoyageServlet2")
public class ModifierDatesVoyageServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page ="";
		
		String dateDepartTemp = request.getParameter("dateDepart");
		String dateRetourTemp = request.getParameter("dateRetour");
		Long id1 = Long.valueOf(request.getParameter("id1"));
		Long id2 = Long.valueOf(request.getParameter("id2"));
		String prixHT = request.getParameter("prixHT");
		float prixHT2 = Float.parseFloat(prixHT);
		String nbplaces = request.getParameter("nbPlaces");
		int nbPlaces2 = Integer.parseInt(nbplaces);
		
		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		dateDepartTemp = dateDepartTemp + " 00:00:00";
		dateRetourTemp = dateRetourTemp + " 00:00:00";
		java.util.Date dateDepart = null;
		java.util.Date dateRetour = null;
		try {
			dateDepart = formater.parse(dateDepartTemp);
			dateRetour = formater.parse(dateRetourTemp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Destination destination = service.findById(id2);
		
		Set<DatesVoyage> datesvoyage = service.getDatesVoyageByDestinationId(id2);
		Iterator<DatesVoyage> it = datesvoyage.iterator();
		while(it.hasNext()) {
			DatesVoyage date = it.next();
			if(date.getId()==id1) {
				date.setDateAller(dateDepart);
				date.setDateRetour(dateRetour);
				date.setPrixHT(prixHT2);
				date.setNbrePlaces(nbPlaces2);
			}
		}
		
		destination.setDatesVoyage(datesvoyage);
		service.update(destination);

		
		Set<DatesVoyage> datesvoyages = (Set<DatesVoyage>)service.getDatesVoyageByDestinationId(id2);
		request.setAttribute("destination", destination);
		request.setAttribute("datesvoyages", datesvoyages);
		
		page = "/show-datesvoyage.jsp";
		
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
