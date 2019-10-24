package fr.gtm.bovoyage2.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	public Set<DatesVoyage> getDatesVoyageByDestinationId(long id){
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Destination destination = em.find(Destination.class, id);
		Set<DatesVoyage> datesVoyage = new HashSet<DatesVoyage>();
		for (DatesVoyage d : destination.getDatesVoyage()){
			datesVoyage.add(d);
			}
		return datesVoyage;
	}
}
