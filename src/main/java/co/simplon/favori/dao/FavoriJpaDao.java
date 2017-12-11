package co.simplon.favori.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import co.simplon.favori.modele.Favori;

@Named
public class FavoriJpaDao implements FavoriDao {
	
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<Favori> findAll(int first, int size){
		return entityManager
				.createNamedQuery("Favori.findAll", Favori.class)
				.setFirstResult(first).setMaxResults(size).getResultList();
		
	}
	
	@Override
	public List<Favori> findAllForCategorieId(Long idCategorie, int first, int size){
		return entityManager
				.createNamedQuery("Favori.findAllByCategorieId", Favori.class)
				.setParameter("id", idCategorie).setFirstResult(first)
				.setMaxResults(size).getResultList();
	}
	
	@Override
	public Favori getFavoriById(Long id){
		return entityManager.find(Favori.class, id);
	}

	@Override
	public void deleteFavoriById(Long id){
		entityManager.getTransaction().begin();
		entityManager.createNamedQuery("Monument.deleteById")
				.setParameter("id", id).executeUpdate();
		entityManager.getTransaction().commit();
  }
	
	@Override
	public Favori updateFavori(Favori favori){
		entityManager.getTransaction().begin();
		favori = entityManager.merge(favori);
		entityManager.getTransaction().commit();
		return favori;
	}
	
	@Override
	public Favori createFavori(Favori favori){
		entityManager.persist(favori);
		return favori;
	}
}
