package com.generation.vehiclesharing.dals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.generation.vehiclesharing.entities.Veicolo;


public class VeicoloDaoImpl implements VeicoloDao {

	
	@Override
	public List<Veicolo> getAll() {
		ConnessioneDatabase db = new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		List<Veicolo> listaVeicoli = new ArrayList<>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			
			ResultSet rs = ps.executeQuery(); 
			
			while (rs.next()) {
				Veicolo veicolo = new Veicolo();
				settaValoriVeicolo(veicolo, rs);
				
				listaVeicoli.add(veicolo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaVeicoli;
	}
	
	private void settaValoriVeicolo(Veicolo veicolo, ResultSet rs) throws SQLException {
		veicolo.setVeicolo_id( rs.getInt("veicolo_id") );
		veicolo.setCategoria( rs.getString("categoria"));
		veicolo.setDescrizione(rs.getString("descrizione"));
		veicolo.setCoordinate( rs.getString("coordinate"));
//		veicolo.setDisponibilita(((ResultSet) rs).getEnum("disponibilita", DisponibilitaVeicoli.class));
		
	}

	@Override
	public Veicolo getVehicleById(int veicolo_id) {
		ConnessioneDatabase db = new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		Veicolo veicolo = new Veicolo();
		try {
			PreparedStatement ps = conn.prepareStatement(VeicoloDao.SELECT_BY_ID);
			
			ps.setInt(1, veicolo_id);
			
			ResultSet rs =ps.executeQuery();
			
			while (rs.next()) {
				settaValoriVeicolo(veicolo, rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return veicolo;
	}

	@Override
	public int update(Veicolo veicolo) {
		ConnessioneDatabase db = new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		int rows = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			
			ps.setString(1, veicolo.getCategoria());
			ps.setString(2, veicolo.getDescrizione());
			ps.setString(3, veicolo.getAlimentazione());
			ps.setString(4, veicolo.getIndirizzo());
			ps.setString(5, veicolo.getCoordinate());
			ps.setInt(6, (int) veicolo.getVeicolo_id());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		
		return rows;
	}

	@Override
	public int deletevVehicleById(int veicolo_id) {
		ConnessioneDatabase db = new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		int rows = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(DELETE);				
			ps.setInt(1, veicolo_id); 			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		
		return rows;
	}

	@Override
	public int addVehicle(Veicolo veicolo) {
		ConnessioneDatabase db = new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		int rows = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			
			ps.setString(1, veicolo.getCategoria());
			ps.setString(2, veicolo.getDescrizione());
			ps.setString(3, veicolo.getAlimentazione());
			ps.setString(4, veicolo.getIndirizzo());
			ps.setString(5, veicolo.getCoordinate());
			ps.setInt(6, (int) veicolo.getVeicolo_id());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		
		return rows;
	}

	@Override
	public Veicolo getByCategoria(String categoria) {
		ConnessioneDatabase db = new ConnessioneDatabase();
		Connection conn = db.getConnection();
		
		Veicolo veicolo = new Veicolo();
		try {

			PreparedStatement ps = conn.prepareStatement("select * from libro where titolo = ? limit 1");

			ps.setString(1, categoria);
			
			ResultSet rs =ps.executeQuery();
			
			while (rs.next()) {
				settaValoriVeicolo(veicolo, rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return veicolo;
	}
	
	
}
