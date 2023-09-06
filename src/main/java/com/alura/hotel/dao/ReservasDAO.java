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

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class ReservasDAO {

	private Connection con;
	public static Integer idGuardado;

	/**
	 * Metodo constructor,
	 * Llama la conexion de la DB
	 */
	public ReservasDAO(Connection con) {

		this.con = con;
	}

	/**
	 * Metodo para guardar la reserva en la DB
	 *
	 * @param reserva
	 */
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

	/**
	 * Metodo que devuelve la lista de reservas
	 *
	 * @return
	 */
	public List<Reservas> listar() {
		List<Reservas> reservas = new ArrayList<>();
		
		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT * FROM reservas");
			
			try (statement) {
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try (resultSet) {
					while (resultSet.next()) {
						reservas.add(new Reservas(
								resultSet.getInt("id"), 
								resultSet.getDate("fecha_entrada"), 
								resultSet.getDate("fecha_salida"), 
								resultSet.getString("forma_pago"),
								resultSet.getFloat("valor")));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return reservas;
	}

	/**
	 * Metodo que devuelve la reserva buscandola por id
	 * @param idReserva
	 * @return
	 */
	public List<Reservas> listarPorId(Integer idReserva) {
		List<Reservas> reservas = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT * FROM reservas "
							+ "WHERE id = ?");

			try(statement) {
				statement.setInt(1, idReserva);
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						reservas.add(new Reservas(
								resultSet.getInt("id"),
								resultSet.getDate("fecha_entrada"),
								resultSet.getDate("fecha_salida"),
								resultSet.getString("forma_pago"),
								resultSet.getFloat("valor")));
					}
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return reservas;
	}

	/**
	 * Metod que elimina una reserva
	 *
	 * @param id
	 * @return
	 */
	public int eliminar(Integer id) {
		try {
			final PreparedStatement statement = con
					.prepareStatement("DELETE FROM reservas WHERE id = ?");
			
			try (statement) {
				statement.setInt(1, id);
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount; 
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}

	/**
	 * Metodo que modifica los datos de la reserva
	 *
	 * @param id
	 * @param fecha_entrada
	 * @param fecha_salida
	 * @param forma_pago
	 * @param valor
	 * @return
	 */
	public int modificar(Integer id, Date fecha_entrada, Date fecha_salida, String forma_pago, Float valor) {
		try {
			final PreparedStatement statement = con
					.prepareStatement("UPDATE reservas SET "
							+ "fecha_entrada = ?, "
							+ "fecha_salida = ?, "
							+ "valor = ?, "
							+ "forma_pago = ?"				
							+ " WHERE id = ?");
			try(statement) {
				statement.setDate(1, fecha_entrada);
				statement.setDate(2, fecha_salida);
				statement.setFloat(3, valor);
				statement.setString(4, forma_pago);			
				statement.setInt(5, id);
				
				int updateCount = statement.executeUpdate();
				
				return updateCount;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Metodo que verifica si existe una reserva en la DB
	 * @param id
	 * @return
	 */
	public int buscarIdReserva(Integer id) {
		Integer id_reserva = 0;

		try {
			String sql = "SELECT COUNT(*) FROM reservas WHERE id = ?";

			final PreparedStatement statement = con.prepareStatement(sql);

			try (statement) {
				statement.setInt(1, id);

				final ResultSet resultSet = statement.executeQuery();

				try (resultSet) {
					if (resultSet.next()) {
						id_reserva = resultSet.getInt(1);
					}

					return id_reserva;
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
