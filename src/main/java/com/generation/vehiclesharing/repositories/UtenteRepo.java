package com.generation.vehiclesharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.vehiclesharing.entities.Utente;



public interface UtenteRepo extends JpaRepository<Utente, Integer> {
	
	Utente findByEmail(String email);
}
