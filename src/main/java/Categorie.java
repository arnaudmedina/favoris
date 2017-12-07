import java.util.List;

public class Categorie {

	private String nom;
	private String description;
	private List<Favori> listeDeFavoris;
	
	public Categorie() {
		super();
		this.nom = "";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Favori> getListeDeFavoris() {
		return listeDeFavoris;
	}

	public void setListeDeFavoris(List<Favori> listeDeFavoris) {
		this.listeDeFavoris = listeDeFavoris;
	}
	
	public void ajouteFavori(Favori unFavori) {
		if (unFavori != null)
			this.listeDeFavoris.add(unFavori);
	}
}
