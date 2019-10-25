package fr.gtm.bovoyage2.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyage2.entities.DatesVoyage;
import fr.gtm.bovoyage2.entities.Destination;



public class DestinationDAO extends AbstractDAO<Destination, Long> {
	
	public DestinationDAO(EntityManagerFactory emf) {
		super(emf, Destination.class);
	}
	
	public List<Destination> getAllDestinations() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<Destination> destinations = em.createNamedQuery("Destination.getAllDestinations", Destination.class).getResultList();
		em.close();
		return destinations;
	}
	
	public List<DatesVoyage> getAllDatesVoyage() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<DatesVoyage> datesVoyage = em.createNamedQuery("DatesVoyage.getAllDatesVoyage", DatesVoyage.class).getResultList();
		
		em.close();
		return datesVoyage;
	}
	

	public List<DatesVoyage> getDatesVoyagesByDestinationId(long id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Destination destination = em.find(Destination.class, id);
		List<DatesVoyage> datesVoyage = destination.getDatesVoyage().stream().collect(Collectors.toList());
		
		em.close();
		return datesVoyage;
	}

	public void create(Date datesVoyage) {
			
			EntityManager em = getEntityManagerFactory().createEntityManager();			
			em.getTransaction().begin();			
			em.persist(datesVoyage);			
			em.getTransaction().commit();
			em.close();
		
	}

	public void update(Date datesVoyage) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(datesVoyage);
		em.getTransaction().commit();
		em.close();
		
	}

	public Set<DatesVoyage> getDatesVoyageById(long id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Destination destination = em.find(Destination.class, id);
		Set<DatesVoyage> datesVoyage = new HashSet<DatesVoyage>();
		
		for(DatesVoyage dates : destination.getDatesVoyage()) {
			datesVoyage.add(dates);
		}
		em.close();
		return datesVoyage;
	}
	
	
	
	public void deleteDatesVoyageByID(long id) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		DatesVoyage datesVoyage = em.find(DatesVoyage.class, id);
		em.remove(datesVoyage);
		em.getTransaction().commit();
		em.close();	
	}
}
