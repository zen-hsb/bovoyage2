package fr.gtm.bovoyage2.servlets;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.gtm.bovoyage2.services.DestinationService;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce)  { 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bovoyage2");
		ServletContext application = sce.getServletContext();
		application.setAttribute(Constantes.EMF, emf);
		DestinationService service = new DestinationService(emf);
		application.setAttribute(Constantes.DESTINATION_SERVICE, service);
	}
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
         emf.close();
    }


	
}
