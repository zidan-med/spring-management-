package org.gestionstock.dao;
import java.util.List;
import org.gestionstock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	public List<Produit> findByNom(String nom);
	public Page<Produit> findByNom(String nom, Pageable pageable);
	
	@Query("select e from Produit e where e.nom like :x")
	public Page<Produit> chercherProduits(@Param("x") String nom,Pageable pageable);
	
	@Query("select e from Produit e where e.prix>:x and e.prix<:y")
	public List<Produit> chercherProduits(@Param("x")double d1,@Param("y")double d2);

}
