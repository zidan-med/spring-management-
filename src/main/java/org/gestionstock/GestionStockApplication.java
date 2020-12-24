package org.gestionstock;

import java.util.List;

import org.gestionstock.dao.ProduitRepository;
import org.gestionstock.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@SpringBootApplication
public class GestionStockApplication {

	public static void main(String[] args) {
	
		ApplicationContext ctx =SpringApplication.run(GestionStockApplication.class, args);
		ProduitRepository produitRepository =
				ctx.getBean(ProduitRepository.class);
				produitRepository.save(new Produit("Table", 150, "photo"));
				produitRepository.save(new Produit("Chaise",40, "photo"));
				produitRepository.save(new Produit("PC", 10900, "photo"));
				produitRepository.save(new Produit("Ramette", 40, "photo"));
				
				Page<Produit> prod1 =
						produitRepository.findAll(PageRequest.of(0, 10));
						prod1.forEach(p->System.out.println("Nom du produit est : " +
						p.getNom()));

						System.out.println();
						Page<Produit> prod2 = produitRepository.chercherProduits("T%",
								PageRequest.of(0, 10));
						prod2.forEach(p->System.out.println("Nom du produit est : " +
						p.getNom()));
						List<Produit> list = produitRepository.findByNom("Chaise");
						list.forEach(p->System.out.println(" ====> " + p.getNom()));
	}

}
