package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradoresDAO {

	private Connection con;
	
	public AdministradoresDAO(Connection con) {
		this.con = con;
	}
	
	public Boolean verificarLogin(String usuario, String contraseña) {
		
		boolean resultado = false;
		
		try {
			String sql = "select * from administradores where usuario = ? and contraseña = ?";
			
			final PreparedStatement statement = con
					.prepareStatement(sql);
			
			try (statement) {
				statement.setString(1, usuario);
				statement.setString(2, contraseña);
				statement.execute();
				
				
				final ResultSet resultSet = statement.executeQuery();
				
				try (resultSet) {
					resultado = resultSet.next() ? true : false;
				}				
			}
			
		} catch (SQLException e) {			
			throw new RuntimeException(e);					
		}
		
		return resultado;
	}
}
