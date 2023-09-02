package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Huespedes;
import com.alura.hotel.modelo.Nacionalidad;

public class HuespedesDAO {

	private Connection con;
	
	public HuespedesDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huespedes huesped) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO huespedes "
					+ "(nombre, apellido, fecha_nacimiento, id_nacionalidad, telefono, id_reserva) "
					+ "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try (statement) {
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getFecha_nacimiento());
				statement.setInt(4, huesped.getId_nacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getId_reserva());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try (resultSet) {
					while (resultSet.next()) {
						huesped.setId(resultSet.getInt(1));
						
						System.out.println(String.format("Fue insertado el huesped: %s", huesped));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huespedes> listar() {
		List<Huespedes> huespedes = new ArrayList<>();
		
		try {
			String sql = "SELECT h.id, h.nombre, h.apellido, h.fecha_nacimiento, n.nombre, h.telefono, h.id_reserva "
					+ "FROM huespedes h "
					+ "INNER JOIN nacionalidad n "
					+ "ON h.id_nacionalidad = n.id;";
			
			final PreparedStatement statement = con
					.prepareStatement(sql);
			
			try (statement) {
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet) {
					while (resultSet.next()) {
						
						huespedes.add(new Huespedes(
								resultSet.getInt("h.id"),
								resultSet.getString("h.nombre"),
								resultSet.getString("h.apellido"),
								resultSet.getDate("h.fecha_nacimiento"),
								resultSet.getString("n.nombre"),
								resultSet.getString("h.telefono"),
								resultSet.getInt("h.id_reserva")));
					}
				}
			} 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return huespedes;
	}
}
