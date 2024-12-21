package com.generation.vehiclesharing.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.vehiclesharing.ResourceNotFoundException;
import com.generation.vehiclesharing.dals.VeicoloDaoImpl;
import com.generation.vehiclesharing.entities.Veicolo;
import com.generation.vehiclesharing.repositories.VeicoloRepo;

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
	
	@PostMapping
	public ResponseEntity<?> addVeicolo(@RequestBody Veicolo veicolo)
	{
		try {
			vdi.addVehicle(veicolo);
			
			return ResponseEntity.ok(veicolo);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Veicolo());
		}
	}
	@Autowired
	VeicoloRepo vr;
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVeicolo(@PathVariable Integer id) throws RuntimeException {
	    Veicolo veicolo = vr.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Veicolo non trovato con ID: " + id));
	    vr.delete(veicolo);
	    return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAll() {
		vr.deleteAll();
		
		return ResponseEntity.noContent().build();
	}
}
