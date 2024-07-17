package it.davimut.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import it.davimut.pizzeria.repository.IngredienteRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {

	
	@Autowired
	private IngredienteRepo IngredienteRepo;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("listaIngredienti", IngredienteRepo.findAll());
		return "/ingredienti/index";
	}
	
}
