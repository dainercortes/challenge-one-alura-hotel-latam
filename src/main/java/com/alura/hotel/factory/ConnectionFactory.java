package com.alura.hotel.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class ConnectionFactory {
	
	private DataSource dataSource;

	/**
	 * Metodo constructor
	 * Realiza la conexion con la DB
	 * Pide datos como la URI, Usuario, Contraseña y limite de conexiones el cual es 10
	 */
	public ConnectionFactory() {
		var comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/alura_hotel?useTimeZone=true&serverTimeZone=UTC");

		comboPooledDataSource.setUser("root"); // Reemplazar por el usuario que asigno en su pc
		comboPooledDataSource.setPassword("0503"); // Reemplazar por la clave que asigno en su pc
		comboPooledDataSource.setMaxPoolSize(10);
		
		this.dataSource = comboPooledDataSource;
	}

	/**
	 * Metodo para recuperar la conexion de la DB
	 * @return
	 */
	public Connection recuperarConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
