package co.simplon.favori.dao;

import java.util.List;

import co.simplon.favori.modele.Favori;

public interface FavoriDao {
	List<Favori> findAll(int first, int size);
	
	List<Favori> findAllForCategorieId(Long idCategorie, int first, int size);
	
	Favori getFavoriById(Long id);

	void deleteFavoriById(Long id);
	
	Favori updateFavori(Favori favori);
	
	Favori createFavori(Favori favori);
}
