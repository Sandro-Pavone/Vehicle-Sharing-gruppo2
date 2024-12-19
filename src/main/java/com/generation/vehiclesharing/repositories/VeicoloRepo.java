package com.generation.vehiclesharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.vehiclesharing.entities.Veicolo;

public interface VeicoloRepo extends JpaRepository<Veicolo, Integer> {

	
}
