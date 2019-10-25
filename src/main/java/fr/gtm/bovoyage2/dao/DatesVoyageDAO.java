package fr.gtm.bovoyage2.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyage2.entities.DatesVoyage;
import fr.gtm.bovoyage2.entities.Destination;

public class DatesVoyageDAO extends AbstractDAO<DatesVoyage, Long> {
	
	public DatesVoyageDAO(EntityManagerFactory emf) {
		super(emf, DatesVoyage.class);
	}
	
	public List<DatesVoyage> getDatesVoyageByDestination(Destination destination) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<DatesVoyage> datesvoyages = em.createNamedQuery("", DatesVoyage.class)
												.setParameter("destination", destination+"%")
												.getResultList();
		em.close();
		return datesvoyages;
	}
}
