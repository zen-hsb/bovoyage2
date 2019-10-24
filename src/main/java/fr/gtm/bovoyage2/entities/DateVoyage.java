package fr.gtm.bovoyage2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="dates_voyages")
@NamedQueries({
	@NamedQuery(name = "DateDeVoyage.getAllDatesVoyage",query = "SELECT v FROM DateDeVoyage v")
})

public class DateVoyage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_date_voyage")
	private long id;
	@Column(name="date_depart")
	private Date dateDepart;
	@Column(name="date_retour")
	private Date dateRetour;
	@Column(name="prixHT")
	private int prixHT;
	@Column(name="nb_places")
	private int nbrePlaces;
	
	

}
