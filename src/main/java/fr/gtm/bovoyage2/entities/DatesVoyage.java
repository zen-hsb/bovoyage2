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
//@NamedQueries({
//	@NamedQuery(name = "DatesVoyage.getWithDatesVoyage",query = "SELECT v FROM DatesVoyage v WHERE v.region LIKE :region"),
//	@NamedQuery(name = "DatesVoyage.getAllDatesVoyage",query = "SELECT v FROM DatesVoyage v")
//})

public class DatesVoyage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_date_voyage")
	private long id;
	@Column(name="date_depart")
	private Date dateDepart;
	@Column(name="date_retour")
	private Date dateRetour;
	@Column(name="prixHT")
	private double prixHT;
	@Column(name="nb_places")
	private int nbrePlaces;
	
	

	public DatesVoyage() {
		
	}

	public DatesVoyage(Date dateDepart, Date dateRetour, int prixHT, int nbrePlaces) {
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.prixHT = prixHT;
		this.nbrePlaces = nbrePlaces;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public int getNbrePlaces() {
		return nbrePlaces;
	}

	public void setNbrePlaces(int nbrePlaces) {
		this.nbrePlaces = nbrePlaces;
	}


	@Override
	public String toString() {
		return "DatesVoyage [id=" + id + ", dateDepart=" + dateDepart + ", dateRetour=" + dateRetour + ", prixHT="
				+ prixHT + ", nbrePlaces=" + nbrePlaces + "]";
	}

	
	
	
	

}
