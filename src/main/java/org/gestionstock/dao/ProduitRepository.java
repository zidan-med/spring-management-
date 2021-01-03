package org.gestionstock.dao;

import org.gestionstock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
    public Page<Produit> findByDesignation(String mc, Pageable pageable);

}
