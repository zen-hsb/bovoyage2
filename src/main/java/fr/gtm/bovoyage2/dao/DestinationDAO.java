package fr.gtm.bovoyage2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyage2.entities.Destination;

public class DestinationDAO extends AbstractDAO<Destination, Long> {
	
	public DestinationDAO(EntityManagerFactory emf) {
		super(emf, Destination.class);
	}
	
	public List<Destination> getDestinations() {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		List<Destination> destinations = em.createNamedQuery("", Destination.class).getResultList();
		em.close();
		return destinations;
	}
}
