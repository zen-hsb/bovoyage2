package fr.gtm.bovoyage2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "destinations")
@NamedQueries({
	@NamedQuery(name = "Destination.getByNom",query = "SELECT d FROM Destination d WHERE d.nom LIKE :nom"),
	@NamedQuery(name = "Destination.getByDateDeVoyage",query = "SELECT d FROM Destination d WHERE d.dates_voyages LIKE :dates_voyages"),
	@NamedQuery(name = "Destination.getAllDestinations",query = "SELECT d FROM Destination d")	
})
public class Destination implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_destination")
	private long id;
	@Enumerated(EnumType.STRING)
	private String region;
	private String description;
	private String nomImages;
	
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "dates_voyages",
			joinColumns=@JoinColumn(name="fk_destination"))
			
	
//	@JoinTable(name = "images",
//			joinColumns=@JoinColumn(name= "fk_destination"))
	
	private List<DateVoyage> datesVoyage = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "images",joinColumns = @JoinColumn(name="fk_destination"))
	@Column(name="images")
	private List<String> images = new ArrayList<>();
	
	
	
	public Destination() {
		
	}
	
	public Destination(String region, String description, String nomImages) {
		this.region = region;
		this.description = description;
		this.nomImages = nomImages;
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	public String getImages() {
		return nomImages;
	}



	public void setImages(String nomImages) {
		this.nomImages = nomImages;
	}


	public List<DateVoyage> getDatesVoyage() {
		return datesVoyage;
	}
	
	public void setDatesVoyage(List <DateVoyage> datesVoyage) {
		this.datesVoyage = datesVoyage;
	}
	
	
	@Override
	public String toString() {
		return "Destination [id=" + id + ", region=" + region + ", description=" + description + ", nomImages=" + nomImages
				+ "]";
	}
	
	
	
	
}
