package com.generation.vehiclesharing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veicolo")
public class Veicolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int veicolo_id;

	@Column(length = 75, nullable = false)
	private String categoria;

	@Column(length = 100, nullable = false)
	private String descrizione;

	@Column(length = 20, nullable = true)
	private String alimentazione;

	@Column(length = 100, nullable = false)
	private String indirizzo;

	@Column(length = 50, nullable = false)
	private String coordinate;

	@Column(name = "disponibilita", columnDefinition = "TINYINT(1)")
	private boolean disponibilita;

	@Column(length = 255, nullable = false)
	private String immagine;

	public long getVeicolo_id() {
		return veicolo_id;
	}

	public void setVeicolo_id(int veicolo_id) {
		this.veicolo_id = veicolo_id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}

	@Override
	public String toString() {
		return "Veicolo [veicolo_id=" + veicolo_id + ", categoria=" + categoria + ", descrizione=" + descrizione
				+ ", alimentazione=" + alimentazione + ", indirizzo=" + indirizzo + ", coordinate=" + coordinate
				+ ", immagine=" + immagine + "]";
	}

}
