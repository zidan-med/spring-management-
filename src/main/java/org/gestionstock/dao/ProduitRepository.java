package org.gestionstock.dao;

import org.gestionstock.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepositry extends JpaRepository<Produit, Long> {

}
