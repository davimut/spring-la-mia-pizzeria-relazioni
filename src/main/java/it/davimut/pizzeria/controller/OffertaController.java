package it.davimut.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.davimut.pizzeria.model.OffertaModel;
import it.davimut.pizzeria.repository.OffertaRepo;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaController {
	@Autowired
	private   OffertaRepo OffertaRepository;

	@PostMapping("/create")
	public String store(
			@Valid @ModelAttribute("offerta") OffertaModel offerta,
			BindingResult bindingResult,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/offerte/edit";
		}
		
		
		OffertaRepository.save(offerta);
		
		return "redirect:/pizzeria/dettaglio/" + offerta.getPizza().getId();
	}
}

