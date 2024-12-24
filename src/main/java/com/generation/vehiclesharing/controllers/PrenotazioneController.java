package com.generation.vehiclesharing.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.vehiclesharing.ResourceNotFoundException;
import com.generation.vehiclesharing.dals.PrenotazioneDaoImpl;
import com.generation.vehiclesharing.entities.Prenotazione;
import com.generation.vehiclesharing.entities.Utente;
import com.generation.vehiclesharing.entities.Veicolo;
import com.generation.vehiclesharing.repositories.PrenotazioneRepo;
import com.generation.vehiclesharing.repositories.UtenteRepo;
import com.generation.vehiclesharing.repositories.VeicoloRepo;





@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {
	@Autowired
	PrenotazioneDaoImpl pdi;
	@Autowired
	VeicoloRepo vr;
	@Autowired
	PrenotazioneRepo pr;
	@Autowired
	UtenteRepo ur;
	
	@GetMapping
	public List<Prenotazione> getAll() {
		return pdi.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPrenotazioneById(@PathVariable("id") int id) {
		Optional<Prenotazione> optional = pdi.getPrenotazioneById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.badRequest().body("Prenotazione non trovata");
		}
	}
	
//	@PostMapping
//	public ResponseEntity<?> addPrenotazione(
//		    @RequestParam("utente_id")
//		    int utente_id,
//		    @RequestParam("veicolo_id")
//		    int veicolo_id) {
//			Veicolo v = vr.findById(veicolo_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "veicolo non trovato") );
//			Utente u = ur.findById(utente_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "utente non trovato") );
//			
//			if (!v.isDisponibilita()) {
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("veicolo già prenotato");
//			}
//			Prenotazione prenotazione = new Prenotazione();
//			prenotazione.setVeicolo(v);
//			prenotazione.setUtente(u);
//			prenotazione.setDataInizio(LocalDateTime.now());
//			v.setDisponibilita(false);
//			vr.save(v);
//			pr.save(prenotazione);
//			return ResponseEntity.status(HttpStatus.CREATED).body("prenotazione effettuata con successo");
//	}
	
	@PostMapping
	public ResponseEntity<?> addPrenotazione(
	        @RequestParam("utente_id") int utente_id,
	        @RequestParam("veicolo_id") int veicolo_id) {

	    try {
	        Veicolo v = vr.findById(veicolo_id)
	                      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veicolo non trovato"));
	        Utente u = ur.findById(utente_id)
	                      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato"));

	        if (!v.isDisponibilita()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                                 .body(Map.of("error", "Veicolo già prenotato"));
	        }

	        Prenotazione prenotazione = new Prenotazione();
	        prenotazione.setVeicolo(v);
	        prenotazione.setUtente(u);
	        prenotazione.setDataInizio(LocalDateTime.now());
	        v.setDisponibilita(false);
	        vr.save(v);
	        pr.save(prenotazione);

	        return ResponseEntity.status(HttpStatus.CREATED)
	                             .body(Map.of("message", "Prenotazione effettuata con successo", 
	                                          "prenotazioneId", prenotazione.getId()));
	    } catch (ResponseStatusException e) {
	        return ResponseEntity.status(e.getStatusCode())
	                             .body(Map.of("error", e.getReason()));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body(Map.of("error", "Errore imprevisto: " + e.getMessage()));
	    }
	}


		    
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePrenotazione(@PathVariable Integer id) throws RuntimeException {
		Prenotazione prenotazione = pr.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Prenotazione non trovata con ID: " + id));
		pr.delete(prenotazione);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAll() {
		pr.deleteAll();
		
		return ResponseEntity.noContent().build();
	}
}
