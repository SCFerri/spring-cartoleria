package it.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.spring.model.Prodotti;
import it.spring.service.ProdottiService;


@Controller
public class ProdottiController {

	@Autowired
	private ProdottiService prodottiService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Prodotti> listProdotti = prodottiService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listProdotti", listProdotti);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newProdottiForm(Map<String, Object> model) {
		Prodotti prodotti = new Prodotti();
		model.put("prodotti", prodotti);
		return "new_prodotti";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProdotti(@ModelAttribute("prodotti") Prodotti prodotti) {
		prodottiService.save(prodotti);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editProdottiForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("edit_prodotti");
		Prodotti prodotti = prodottiService.get(id);
		mav.addObject("prodotti", prodotti);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteProdottiForm(@RequestParam Long id) {
		prodottiService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Prodotti> result = prodottiService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}
