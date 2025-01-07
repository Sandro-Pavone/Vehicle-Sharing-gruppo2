package com.generation.vehiclesharing.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.vehiclesharing.entities.Utente;
import com.generation.vehiclesharing.enums.Ruolo;
import com.generation.vehiclesharing.repositories.UtenteRepo;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller

public class LoginController {

	@Autowired
	private UtenteRepo utenteRepo;


	@GetMapping("/login")
	public String showLoginPage() {
		return "login"; 
	}

	@PostMapping("/login")
	public String handleLogin(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {
		
		Utente utente = utenteRepo.findByEmail(email);

		if (utente != null && utente.getPassword().equals(password)) {
			
			session.setAttribute("email", utente.getEmail());
			session.setAttribute("ruolo", utente.getRuolo().name()); 

			
			if (utente.getRuolo() == Ruolo.ADMIN || utente.getRuolo() == Ruolo.UTENTE) {
				return "redirect:/home"; 
			} else {
				return "redirect:/login"; 
			}
		}

		
		model.addAttribute("error", "Credenziali errate!");
		return "login";
	}

	@GetMapping("/home")
	public String showHomePage(HttpSession session, Model model) {
		
		String email = (String) session.getAttribute("email");
		String ruoloString = (String) session.getAttribute("ruolo");

		if (email != null && ruoloString != null) {
			try {
				Ruolo ruolo = Ruolo.valueOf(ruoloString); 
				model.addAttribute("email", email);
				model.addAttribute("ruolo", ruolo);
			} catch (IllegalArgumentException e) {
				model.addAttribute("error", "Ruolo non valido nella sessione!");
				return "error";
			}
		}

		return "index"; 
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/login"; 
	}
}
