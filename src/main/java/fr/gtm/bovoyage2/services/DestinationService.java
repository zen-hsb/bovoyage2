package fr.gtm.bovoyage2.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.bovoyage2.dao.DestinationDAO;
import fr.gtm.bovoyage2.entities.DatesVoyage;
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
	
	public List<Destination> getAllDestinations() {
		return destinationdao.getAllDestinations();
	}
	
	public Destination findById(long id) {
		return destinationdao.findById(id);
	}

	public List<DatesVoyage> getAllDatesVoyage() {
		return destinationdao.getAllDatesVoyage();
	}
	
//	public List<DatesVoyage> getDatesVoyageByDestination() {
//		return destinationdao.getDatesVoyageByDestination();
//	}
	
	public List<DatesVoyage> getDatesVoyageByDestinationId(long id) {
		return destinationdao.getDatesVoyagesByDestinationId(id);
	}

	public void create(Date datesVoyage) {
		destinationdao.create(datesVoyage);
	}
	
	
	public void update(Date datesVoyage) {
		destinationdao.update(datesVoyage);
	}

//	public Destination getDestinationById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	public Set<DatesVoyage> getDatesVoyageById(long id) {
		return destinationdao.getDatesVoyageById(id);
	}

	
	


}
