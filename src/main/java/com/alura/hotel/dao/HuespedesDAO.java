package com.alura.hotel.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.modelo.Huespedes;
import com.alura.hotel.modelo.Nacionalidad;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class HuespedesDAO {

	private Connection con;

	/**
	 * Metodo constructor
	 * Recibe la conexion de la DB
	 *
	 * @param con
	 */
	public HuespedesDAO(Connection con) {

		this.con = con;
	}

	/**
	 * Metodo para guardar los datos del huesped en la DB
	 *
	 * @param huesped
	 * @param id_nacionalidad
	 * @param id_reserva
	 */
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

	/**
	 * Metodo que devuelve la lista de huespedes registrados
	 * @return
	 */
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

	/**
	 * Metodo que devuelve la lista de huespedes buscandolos por apellido
	 *
	 * @param apellido
	 * @return
	 */
	public List<Huespedes> listarPorApellido(String apellido) {
		List<Huespedes> huespedes = new ArrayList<>();
		
		try {
			String sql = "SELECT h.id, h.nombre, h.apellido, h.fecha_nacimiento, n.nombre, h.telefono, h.id_reserva "
					+ "FROM huespedes h "
					+ "INNER JOIN nacionalidad n "
					+ "ON h.id_nacionalidad = n.id "
					+ "WHERE h.apellido LIKE ?";
			
			final PreparedStatement statement = con
					.prepareStatement(sql);
			
			try (statement) {
				statement.setString(1, "%" + apellido + "%");
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try (resultSet) {
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

	/**
	 * Metodo que elimina un huesped
	 *
	 * @param id
	 * @return
	 */
	public int eliminar(Integer id) {
		try {
			final PreparedStatement statement = con
					.prepareStatement("DELETE FROM huespedes WHERE id = ?");
			
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
	 * Metodo que elimina la reserva del huesped
	 *
	 * @param id_reserva
	 * @return
	 */
	public int eliminarConReserva(Integer id_reserva) {
		try {
			final PreparedStatement statement = con
					.prepareStatement("DELETE FROM huespedes WHERE id_reserva = ?");
			
			try (statement) {
				statement.setInt(1, id_reserva);
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount; 
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}

	/**
	 * Metodo que modifica los datos del huesped
	 *
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param nacionalidad
	 * @param telefono
	 * @param numReserva
	 * @return
	 */
	public int modificar(Integer id, String nombre, String apellido, Date fechaNacimiento, Integer nacionalidad, String telefono, Integer numReserva) {
		try {
			final PreparedStatement statement = con
					.prepareStatement("UPDATE huespedes SET " +
							"nombre = ?," +
							"apellido = ?," +
							"fecha_nacimiento = ?," +
							"id_nacionalidad = ?," +
							"telefono = ?," +
							"id_reserva = ?"
							+ " WHERE id = ?");
			try(statement) {
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setDate(3, fechaNacimiento);
				statement.setInt(4, nacionalidad);
				statement.setString(5, telefono);
				statement.setInt(6, numReserva);
				statement.setInt(7, id);

				int updateCount = statement.executeUpdate();

				return updateCount;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Metodo que busca si una reserva esta asociafa a un cliente
	 *
	 * @param id
	 * @param id_r
	 * @return
	 */
	public int buscarIdReservaHuesped(Integer id, Integer id_r) {
		Integer id_reserva = 0;

		try {
			String sql = "SELECT COUNT(*) FROM huespedes WHERE id != ? AND id_reserva = ?";

			final PreparedStatement statement = con.prepareStatement(sql);

			try (statement) {
				statement.setInt(1, id);
				statement.setInt(2, id_r);

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
