package com.generation.vehiclesharing.dals;

import java.util.List;
import java.util.Optional;

import com.generation.vehiclesharing.entities.Veicolo;

public interface VeicoloDao {
	
	String SELECT_ALL = "Select * from veicolo";
	String SELECT_BY_ID = "select * from veicolo where id = ?";
	String UPDATE = "update veicolo set categoria  = ?, descrizione = ?, alimentazione =?, indirizzo = ? coordinate = ?";
	String DELETE = "delete from veicolo where id = ?";
	String INSERT = "Insert into veicolo(categoria, descrizione, alimentazione, indirizzo, coordinate, disponibilita) values(?,?,?,?,?,?)";
	//CRUD
		public List<Veicolo> getAll(); //read
		public Optional<Veicolo> getVehicleById(int veicolo_id); //read one
//		int update(Veicolo veicolo); //update
		int deletevVehicleById(int veicolo_id); //delete
		public void addVehicle(Veicolo veicolo);//create
//		Veicolo getByCategoria(String string);//read
}
