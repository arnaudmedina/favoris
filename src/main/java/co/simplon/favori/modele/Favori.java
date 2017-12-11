package co.simplon.favori.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "favori")
@NamedQueries({
		@NamedQuery(name = "Favori.findAll", query = " SELECT v FROM Favori v ORDER BY v.nom "),
		@NamedQuery(name = "Favori.deleteById", query = " DELETE FROM Favori v WHERE v.id = :id") })
public class Favori {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "dateCrea")
	private Date dateCrea;
	
	@Column(name = "dateModif")
	private Date dateModif;
	
	@Column(name = "supprime")
	private Boolean supprime;
	
	@Column(name = "urlImage")
	private String urlImage;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "favori", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Categorie> categories;

	public Favori() {
	}
	
	public Favori(String nom, String url) {
		setNom(nom);
		setUrl(url);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public Boolean getSupprime() {
		return supprime;
	}

	public void setSupprime(Boolean supprime) {
		this.supprime = supprime;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Categorie> getListeCategories() {
		return categories;
	}

	public void setListeCategories(Set<Categorie> categories) {
		this.categories = categories;
	}
	
	

}
