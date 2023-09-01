package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.alura.hotel.modelo.Huespedes;

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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
