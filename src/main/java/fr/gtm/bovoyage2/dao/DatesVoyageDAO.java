package fr.gtm.bovoyage2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DatesVoyageDAO extends AbstractDAO<DatesVoyage, Long> {
	
	public DatesVoyageDAO(EntityManagerFactory emf) {
		super(emf, DatesVoyage.class);
	}
	
	public List<DatesVoyage> getDatesVoyageByDestination(Destination destination) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<DatesVoayge> datesvoyages = em.createNamedQuery("", DatesVoyage.class)
												.setParameter("destination", destination+"%")
												.getResultList();
		em.close();
		return datesvoyages;
	}

}
