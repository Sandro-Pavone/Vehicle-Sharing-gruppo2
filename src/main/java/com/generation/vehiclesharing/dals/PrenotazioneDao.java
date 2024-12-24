package com.generation.vehiclesharing.dals;

import java.util.List;
import java.util.Optional;

import com.generation.vehiclesharing.entities.Prenotazione;

public interface PrenotazioneDao {

	public List<Prenotazione> getAll();
	public Optional<Prenotazione> getPrenotazioneById(int id);
	// Prenotazione updatePrenotazione(Prenotazione prenotazione);
	int deletePrenotazioneById(int id);
	public Prenotazione addPrenot(Prenotazione prenotazione);
	
}
