package org.gestionstock;

import org.gestionstock.dao.ProduitRepositry;
import org.gestionstock.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestionStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionStockApplication.class, args);
		ApplicationContext ctx =SpringApplication.run(GestionStockApplication.class, args);
		ProduitRepositry produitRepository =ctx.getBean(ProduitRepositry.class);
		produitRepository.save(new Produit("Table", 150, "photo"));
	}

}
