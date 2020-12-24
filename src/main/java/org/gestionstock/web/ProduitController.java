package org.gestionstock.web;


import org.gestionstock.dao.ProduitRepository;
import org.gestionstock.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/Produit")
public class ProduitController {
	 
	@Autowired
	private ProduitRepository produitRepository;
	@RequestMapping(value="/Index")
	public String Index(Model model,@RequestParam(name="page", defaultValue="0") int p,
			@RequestParam(name="motCle", defaultValue="") String mc) {
		Page<Produit> pageProduits = produitRepository.chercherProduits(mc,PageRequest.of(p, 2));
		int pagesCount = pageProduits.getTotalPages();
		int [] pages = new int[pagesCount];
		for(int i=0;i<pagesCount;i++) { pages[i] = i; }
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);
		model.addAttribute("pageProduits", pageProduits);
		return "produits";
		}
	
		/*
		 * private static final String PATH="error";
		 * 
		 * @RequestMapping(value=PATH) public String defaultErrorMessage() { return
		 * "Ressourse is not found..!!"; }
		 * 
		 * 
		 * public String getErrorPath() { return PATH; }
		 */
		 
}
