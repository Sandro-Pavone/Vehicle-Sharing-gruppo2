package com.generation.vehiclesharing.controllers;

import java.util.List;

import com.generation.vehiclesharing.dals.VeicoloDaoImpl;
import com.generation.vehiclesharing.entities.Veicolo;
import com.generation.vehiclesharing.views.VeicoloView;



public class VeicoloController {

	public static void main(String[] args) {
		
		VeicoloDaoImpl veicoloDao = new VeicoloDaoImpl();
		
		//tutti i libri
		List<Veicolo> veicoli = veicoloDao.getAll();
		
		VeicoloView vv = new VeicoloView();
		VeicoloView.stampaVeicoli(veicoli);
		
		
		
		
	}
}
