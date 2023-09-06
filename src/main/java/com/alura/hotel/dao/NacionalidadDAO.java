package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Nacionalidad;

public class NacionalidadDAO {

	private Connection con;
	
	public NacionalidadDAO(Connection con) {
		this.con = con;
	}
	
	public List<Nacionalidad> listar() {
		List<Nacionalidad> resultado = new ArrayList<>();
		
		try {
			String sql = "SELECT id, nombre FROM nacionalidad ORDER BY nombre";
			
			final PreparedStatement statement = con
					.prepareStatement(sql);
			
			try(statement) {
				final ResultSet resultSet = statement.executeQuery();
				
				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Nacionalidad(
								resultSet.getInt("id"),
								resultSet.getString("nombre")));
					}
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return resultado;
	}
	public int buscarPorNombre(String nombre) {
		Integer id = 0;

		try {
			String sql = "SELECT id FROM nacionalidad WHERE nombre LIKE ? LIMIT 1";

			final PreparedStatement statement = con.prepareStatement(sql);

			try (statement) {
				statement.setString(1, "%" + nombre + "%");
				final ResultSet resultSet = statement.executeQuery();

				try (resultSet) {
					if(resultSet.next()) {
						id = resultSet.getInt(1);
					}

					return id;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
