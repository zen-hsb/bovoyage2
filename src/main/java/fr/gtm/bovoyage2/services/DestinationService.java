package fr.gtm.bovoyage2.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyage2.dao.DestinationDAO;
import fr.gtm.bovoyage2.entities.Destination;

public class DestinationService {
	
	private DestinationDAO destinationdao;
	
	public DestinationService(EntityManagerFactory emf) {
		destinationdao = new DestinationDAO(emf);
	}
	
	public void create(Destination destination) {
		destinationdao.create(destination);
	}
	
	public void update(Destination destination) {
		destinationdao.update(destination);
	}
	
	public void delete(long id) {
		destinationdao.delete(id);
	}
	
	public List<Destination> getDestinations() {
		return destinationdao.getDestinations();
	}
	
	public Destination findById(long id) {
		return destinationdao.findById(id);
	}

}
