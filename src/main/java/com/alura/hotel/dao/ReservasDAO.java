package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Reservas;

public class ReservasDAO {

	private Connection con;
	public static Integer idGuardado;
	
	public ReservasDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Reservas reserva) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO reservas "
					+ "(fecha_entrada, fecha_salida, forma_pago, valor) "
					+ "values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try (statement) {
				statement.setDate(1, (Date) reserva.getFecha_entrada());
				statement.setDate(2, (Date) reserva.getFecha_salida());
				statement.setString(3, reserva.getForma_pago());
				statement.setFloat(4, reserva.getValor());
				
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try (resultSet) {
					while (resultSet.next()) {
						reserva.setId(resultSet.getInt(1));
						
						System.out.println(String.format("Fue insertada la reserva No: %s", reserva.getId()));
					}
				}
			}		
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reservas> listar() {
		List<Reservas> reservas = new ArrayList<>();
		
		return reservas;
	}
	
	public int eliminar(Integer id) {
		return 0; 
	}
	
	public int modificar(Date fecha_entrada, Date fecha_salida, String forma_pago, Float valor) {
		return 0;
	}
}
