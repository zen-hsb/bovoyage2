package fr.gtm.bovoyage2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="dates_voyages")
@NamedQueries({
	@NamedQuery(name = "DateDeVoyage.getAllDatesVoyage",query = "SELECT v FROM DateDeVoyage v")
})

public class DateVoyage implements Serializable {
	private long id;
	private Date dateAller;
	private Date dateRetour;
	private int prixHT;
	private int nbrePlaces;
	
	

}
