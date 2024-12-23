package com.generation.vehiclesharing.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.generation.vehiclesharing.ResourceNotFoundException;
import com.generation.vehiclesharing.dals.VeicoloDaoImpl;
import com.generation.vehiclesharing.entities.Veicolo;
import com.generation.vehiclesharing.repositories.VeicoloRepo;

@RestController
@RequestMapping("/api/veicoli")
public class VeicoloController {
	@Autowired
	VeicoloDaoImpl vdi;
	
//	@CrossOrigin(origins = "http://127.0.0.1:5502")
	@GetMapping
	public List<Veicolo> getAll() {
		return vdi.getAll();
	}
	
//	@CrossOrigin(origins = "http://127.0.0.1:5502")
	@GetMapping("/{id}")
	public ResponseEntity<?> getVeicoloById(@PathVariable("id") int veicolo_id) {
		Optional<Veicolo> optional = vdi.getVehicleById(veicolo_id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.badRequest().body("Veicolo non trovato");
		}
	
	}
	
//	@PostMapping
//	public ResponseEntity<?> addVeicolo(@RequestBody Veicolo veicolo)
//	{
//		try {
//			vdi.addVehicle(veicolo);
//			
//			return ResponseEntity.ok(veicolo);
//		} catch (Exception e) {
//			return ResponseEntity.internalServerError().body(new Veicolo());
//		}
//	}
	
	
//	@CrossOrigin(origins = "http://127.0.0.1:5502")
	@PostMapping
	public ResponseEntity<?> addVeicolo(
	    @RequestParam("categoria")
	    String categoria,
	    @RequestParam("descrizione")
	    String descrizione,
	    @RequestParam("alimentazione")
	    String alimentazione,
	    @RequestParam("indirizzo")
	    String indirizzo,
	    @RequestParam("coordinate")
	    String coordinate,
//	    @RequestParam("disponibilita")
//	    String disponibilitaStr,
	    @RequestParam("disponibilita")
	    boolean disponibilita,
	    @RequestParam(value = "image", required = false)
	    MultipartFile immagine) {
	    
	    try {
	    	
	    	System.out.println("Ricevuto veicolo: " + categoria + ", " + descrizione);
	    	System.out.println("Disponibilità: " + disponibilita);
	    	System.out.println("Coordinate: " + coordinate);
	    	
	    	byte[] imageBytes = null;
	        if (immagine != null && !immagine.isEmpty()) {
	            imageBytes = immagine.getBytes();
	        }
	    	
//	    	Boolean disponibilita = "disponibile".equals(disponibilitaStr);
	        
	        Veicolo veicolo = new Veicolo();
	        veicolo.setCategoria(categoria);
	        veicolo.setDescrizione(descrizione);
	        veicolo.setAlimentazione(alimentazione);
	        veicolo.setIndirizzo(indirizzo);
	        veicolo.setCoordinate(coordinate);
	        veicolo.setDisponibilita(disponibilita);
//	        veicolo.setImmagine(image.getBytes());
//	        byte[] imageBytes = immagine.getBytes();
	        veicolo.setImmagine(imageBytes);

	        
	        Veicolo veicoloAggiunto = vdi.addVehicle(veicolo);
	        
//	        return ResponseEntity.ok(veicoloAggiunto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(veicoloAggiunto);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                 .body("Errore durante l'inserimento del veicolo: " + e.getMessage());
	    }
	}
	
//	@PostMapping
//	public ResponseEntity<?> addVeicolo(@RequestBody Veicolo veicolo) {
//	    try {
//	        // Stampa per verificare i dati ricevuti
//	        System.out.println("Ricevuto veicolo: " + veicolo);
//
//	        // Salvataggio nel database
//	        Veicolo veicoloAggiunto = vdi.addVehicle(veicolo);
//
//	        // Risposta
//	        return ResponseEntity.status(HttpStatus.CREATED).body(veicoloAggiunto);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                .body("Errore durante l'inserimento del veicolo: " + e.getMessage());
//	    }
//	}


	
	
	
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
