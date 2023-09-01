package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
