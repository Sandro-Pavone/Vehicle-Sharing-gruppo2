
	package com.generation.vehiclesharing.views;

	import java.util.Iterator;
	import java.util.List;
	import com.generation.vehiclesharing.entities.Veicolo;

	public class VeicoloView {

		public static void stampaVeicoli(List<Veicolo> veicoli) {
			for (Veicolo veicolo : veicoli) {
				System.out.println(veicolo);
			}
		}
		
		public static void stampaVeicoli(Veicolo veicolo) {
			System.out.println(veicolo);
		}
			
	};

