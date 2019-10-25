package fr.gtm.bovoyage2.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.bovoyage2.entities.DatesVoyage;
import fr.gtm.bovoyage2.entities.Destination;
import fr.gtm.bovoyage2.services.DestinationService;


@WebServlet("/ModifierDatesVoyageServlet")
public class ModifierDatesVoyageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DestinationService service = (DestinationService) getServletContext().getAttribute(Constantes.DESTINATION_SERVICE);
		String page = "";
		
		Long idDates = Long.valueOf(request.getParameter("id"));
		Long idDest = Long.valueOf(request.getParameter("id2"));
		
		String prixHT = request.getParameter("prixHT");
		String nbrePlaces = request.getParameter("nbrePlaces");
		
		String dateDepartNew = request.getParameter("dateDepartNew");
		String dateRetourNew = request.getParameter("dateRetourNew");
		double prixHTNew = Double.parseDouble(prixHT);
		int nbrePlacesNew = Integer.parseInt(nbrePlaces);
		
		DatesVoyage datesVoyage = new DatesVoyage();
		
		dateDepartNew = dateDepartNew+("00:00:00");
		dateRetourNew = dateRetourNew+("00:00:00");
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		java.util.Date dateDepart = null;
		java.util.Date dateRetour = null;
			try {
				dateDepart = formatter.parse(dateDepartNew);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dateRetour = formatter.parse(dateRetourNew);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			Iterator <DatesVoyage> iterator1 = datesVoyage.iterator();		
			while(iterator1.hasNext()) {									//renvoie vrai si l'itération a plus d'éléments
				datesVoyage = iterator1.next();								//renvoie l'élément suivant dans l'itération
				if(iterator1.next().getId()==idDates) {
				datesVoyage.setDateDepart(dateDepart);	
				datesVoyage.setDateRetour(dateRetour);
				datesVoyage.setPrixHT(prixHTNew);
				datesVoyage.setNbrePlaces(nbrePlacesNew);
					
				}	
				
			    System.out.println(iterator1.next());
			        
			}	
			
//			for(DatesVoyage dates : dateDepart1) {
//			datesVoyage.setDateDepart(dateDepart);
//			datesVoyage.setDateRetour(dateRetour);
//			datesVoyage.setPrixHT(prixHTNew);
//			datesVoyage.setNbrePlaces(nbrePlacesNew);
			Destination destination = service.findById(idDest);
			
			
			Set<DatesVoyage> dates = service.getDatesVoyageById(idDest);
			dates.add(datesVoyage);
			destination.setDatesVoyage(dates);
			service.update(destination);
			
			Set<DatesVoyage> dates2 = (Set<DatesVoyage>)service.getDatesVoyageById(idDest);
		
		
			request.setAttribute("destination", destination);
			request.setAttribute("dates_voyages", dates);
		
		
			page = "/show-datesVoyage.jsp";
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
