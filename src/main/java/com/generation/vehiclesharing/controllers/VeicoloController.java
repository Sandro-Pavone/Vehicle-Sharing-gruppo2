package com.generation.vehiclesharing.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.vehiclesharing.dals.VeicoloDaoImpl;
import com.generation.vehiclesharing.entities.Veicolo;

@RestController
@RequestMapping("/api/veicoli")
public class VeicoloController {
	@Autowired
	VeicoloDaoImpl vdi;

	@GetMapping
	public List<Veicolo> getAll() {
		return vdi.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getVeicoloById(@PathVariable("id") int veicolo_id) {
		Optional<Veicolo> optional = vdi.getVehicleById(veicolo_id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.badRequest().body("Veicolo non trovato");
		}
	
	}
}
