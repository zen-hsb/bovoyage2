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
	
	public void delete(String id) {
		long identifiant = Long.parseLong(id);
		destinationdao.delete(identifiant);
	}
	
	public List<Destination> getAllDestinations() {
		return destinationdao.getAllDestinations();
	}
	
	public Destination findById(long id) {
		return destinationdao.findById(id);
	}

}
