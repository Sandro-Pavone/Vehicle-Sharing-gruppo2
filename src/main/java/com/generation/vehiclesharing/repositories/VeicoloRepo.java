package com.generation.vehiclesharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.vehiclesharing.entities.Veicolo;

@Repository
public interface VeicoloRepo extends JpaRepository<Veicolo, Integer> {

	
}
