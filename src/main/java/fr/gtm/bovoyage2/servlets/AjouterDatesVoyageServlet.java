package fr.gtm.bovoyage2.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


@WebServlet("/AjouterDatesVoyageServlet")
public class AjouterDatesVoyageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
		
		
		Long id = Long.valueOf(request.getParameter("id2"));
//		String dateDepart = request.getParameter("dateDepart");
//		String dateRetour = request.getParameter("dateRetour");
		String prixHT = request.getParameter("prixHT");
		String nbrePlaces = request.getParameter("nbrePlaces");
		
		String dateDepartNew = request.getParameter("dateDepartNew");
		String dateRetourNew = request.getParameter("dateRetourNew");
		double prixHTNew = Double.parseDouble(prixHT);
		int nbrePlacesNew = Integer.parseInt(nbrePlaces);
		
		DatesVoyage datesVoyage = new DatesVoyage();		//dateDepart, dateRetour, prixHt, nbrePlaces
		
		dateDepartNew = dateDepartNew + (" 00:00:00");
		dateRetourNew = dateRetourNew + (" 00:00:00");
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		
			
		java.util.Date dateDepart = null;
		java.util.Date dateRetour = null;
			try {
				dateDepart = formatter.parse(dateDepartNew);
				dateRetour = formatter.parse(dateRetourNew);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
			
			
			
			
			
			
			
			
//		java.util.Date dateDepart = null;
//		java.util.Date dateRetour = null;
	
		datesVoyage.setDateDepart(dateDepart);
		datesVoyage.setDateRetour(dateRetour);
		datesVoyage.setPrixHT(prixHTNew);
		datesVoyage.setNbrePlaces(nbrePlacesNew);
		Destination destination = service.findById(id); //appelle la méthode "find(destination)ById"
		
		Set<DatesVoyage> dates = service.getDatesVoyageById(id);	//appelle méthode "getDatesVoyageBy(Destination)Id"
		dates.add(datesVoyage);
		destination.setDatesVoyage(dates);
		service.update(destination);
		
		Set<DatesVoyage> dates2 = (Set<DatesVoyage>)service.getDatesVoyageById(id);
		request.setAttribute("destination", destination);
		request.setAttribute("datesVoyage", datesVoyage);

		page = "/show-datesVoyage.jsp";
		
		
		
//		Date date = new SimpleDateFormat("YYYY-MM-DD").parse(dateDepart);
//		Date dateDepart = formatter.parse(dateDepartNew);		
		
//		service.create(datesVoyage);
//		String dateDepartNew = get("dateDepart");
				
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
