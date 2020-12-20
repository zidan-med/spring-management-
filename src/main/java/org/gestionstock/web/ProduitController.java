package org.gestionstock.web;


import java.util.List;

import org.gestionstock.dao.ProduitRepository;
import org.gestionstock.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/Produit")
public class ProduitController {
	/* private static final String PATH="error"; */
	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/Index")
	public String Index(Model model) {
		List<Produit> prods = produitRepository.findAll();
		model.addAttribute("produits", prods);
		return "produits";
		}
	
		/*
		 * @RequestMapping(value=PATH) public String defaultErrorMessage() { return
		 * "Ressourse is not found..!!"; }
		 */
		/*
		 * @Override public String getErrorPath() { // TODO Auto-generated method stub
		 * return PATH; }
		 */
}
