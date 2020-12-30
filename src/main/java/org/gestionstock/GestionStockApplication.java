package org.gestionstock;

import org.gestionstock.dao.ProduitRepository;
import org.gestionstock.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionStockApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionStockApplication.class, args);
		
	
		}

	@Override
	public void run(String... args) throws Exception {
		produitRepository.save(new Produit("PC 5645", 6000, "12"));
		produitRepository.save(new Produit("imprimante HP 3323",4860, "10"));
		produitRepository.save(new Produit("X Comppaq", 10090, "13"));
		produitRepository.save(new Produit("Ramette", 40, "3"));
		produitRepository.save(new Produit("scanner", 550, "20"));
		produitRepository.save(new Produit("table",300, "20"));
		produitRepository.save(new Produit("clavier", 100, "15"));
		produitRepository.save(new Produit("souri", 400, "10"));
		produitRepository.save(new Produit("RAM", 500, "24"));
		produitRepository.save(new Produit("disque dure",405, "40"));
		produitRepository.save(new Produit("camera",900, "23"));
		produitRepository.save(new Produit("PC 4440", 4000, "40"));
		
	}
}


		


