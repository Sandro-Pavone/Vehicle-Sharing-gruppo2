package com.generation.vehiclesharing.dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.vehiclesharing.entities.Veicolo;
import com.generation.vehiclesharing.repositories.VeicoloRepo;


public class VeicoloDaoImpl implements VeicoloDao {
@Autowired
VeicoloRepo veicoloRepo;
//prova commit
	
	@Override
	public List<Veicolo> getAll() {
		return veicoloRepo.findAll();
	}
	
	private void settaValoriVeicolo(Veicolo veicolo, ResultSet rs) throws SQLException {
		veicolo.setVeicolo_id( rs.getInt("veicolo_id") );
		veicolo.setCategoria( rs.getString("categoria"));
		veicolo.setDescrizione(rs.getString("descrizione"));
		veicolo.setCoordinate( rs.getString("coordinate"));
//		veicolo.setDisponibilita(((ResultSet) rs).getEnum("disponibilita", DisponibilitaVeicoli.class));
		
	}

	@Override
	public Optional<Veicolo> getVehicleById(int veicolo_id) {
		return veicoloRepo.findById(veicolo_id);
	}

	@Override
	public int update(Veicolo veicolo) {
		
		return 0;
		
	}

	@Override
	public int deletevVehicleById(int veicolo_id) {
		return 0;
		
	
	}

	@Override
	public int addVehicle(Veicolo veicolo) {
		return 0;
	
	}

	@Override
	public Veicolo getByCategoria(String categoria) {
		return null;
	
	}
	
	
}
