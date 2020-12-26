package org.gestionstock.web;


import java.io.File;

import javax.validation.Valid;

import org.gestionstock.dao.ProduitRepository;
import org.gestionstock.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


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
	@RequestMapping(value="/Form", method=RequestMethod.GET)
	public String formProduit(Model model) {
		model.addAttribute("produit", new Produit("exemple", 0.0, "exemple.jpg"));
		return "formProduit";
		}
	
	@RequestMapping(value="/enregistrerProduit", method=RequestMethod.POST)
	public String enregistrerProduit(
	@Valid Produit pd, BindingResult bindBindingResult,
	@RequestParam(name="picture") MultipartFile file) throws Exception {
		if(bindBindingResult.hasErrors()) {
			return "formProduit";
			}
		if(!file.isEmpty()) {
			pd.setPhoto(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.home") + "/stock/" + file.getOriginalFilename()));
			}
		produitRepository.save(pd);
		return "redirect:Index";
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
