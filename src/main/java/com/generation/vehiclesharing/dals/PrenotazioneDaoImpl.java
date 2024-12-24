package com.generation.vehiclesharing.dals;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.generation.vehiclesharing.entities.Prenotazione;
import com.generation.vehiclesharing.repositories.PrenotazioneRepo;

@Repository
public class PrenotazioneDaoImpl implements PrenotazioneDao {
@Autowired
PrenotazioneRepo pr;

	@Override
	public List<Prenotazione> getAll() {
		return pr.findAll();
	}

	@Override
	public Optional<Prenotazione> getPrenotazioneById(int id) {
		return pr.findById(id);
	}

//	@Override
//	public Prenotazione updatePrenotazione(Prenotazione prenotazione) {
//		return null;
//	}

	@Override
	public int deletePrenotazioneById(int id) {
		return 0;
	}

	@Override
	public Prenotazione addPrenot(Prenotazione prenotazione) {
		Prenotazione prenotazioneSalvata = pr.save(prenotazione);
		return prenotazioneSalvata;
	}

}
