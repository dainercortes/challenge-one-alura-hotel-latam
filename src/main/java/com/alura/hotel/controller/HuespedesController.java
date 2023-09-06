package com.alura.hotel.controller;

import java.sql.Date;
import java.util.List;

import com.alura.hotel.dao.HuespedesDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huespedes;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class HuespedesController {
	
	private HuespedesDAO huespedDAO;

	/**
	 * Metodo constructor,
	 * Llama la conexion de la DB
	 */
	public HuespedesController() {
		var factory = new ConnectionFactory();
		this.huespedDAO = new HuespedesDAO(factory.recuperarConexion());
	}

	/**
	 * Metodo para guardar los datos del huesped en la DB
	 *
	 * @param huesped
	 * @param id_nacionalidad
	 * @param id_reserva
	 */
	public void guardar(Huespedes huesped, Integer id_nacionalidad, Integer id_reserva) {
		huesped.setId_nacionalidad(id_nacionalidad);
		huesped.setId_reserva(id_reserva);
		huespedDAO.guardar(huesped);
	}

	/**
	 * Metodo que devuelve la lista de huespedes registrados
	 * @return
	 */
	public List<Huespedes> listar() {

		return huespedDAO.listar();
	}

	/**
	 * Metodo que devuelve la lista de huespedes buscandolos por apellido
	 *
	 * @param apellido
	 * @return
	 */
	public List<Huespedes> listarPorApellido(String apellido) {

		return huespedDAO.listarPorApellido(apellido);
	}

	/**
	 * Metodo que elimina un huesped
	 *
	 * @param id
	 * @return
	 */
	public int eliminar(Integer id) {

		return huespedDAO.eliminar(id);
	}

	/**
	 * Metodo que elimina la reserva del huesped
	 *
	 * @param id_reserva
	 * @return
	 */
	public int eliminarConReserva(Integer id_reserva) {

		return huespedDAO.eliminarConReserva(id_reserva);
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
		return huespedDAO.modificar(id, nombre, apellido, fechaNacimiento, nacionalidad, telefono, numReserva);
	}

	/**
	 * Metodo que busca si una reserva esta asociafa a un cliente
	 *
	 * @param id
	 * @param id_r
	 * @return
	 */
	public int buscarIdReservaHuesped(Integer id, Integer id_r) {
		return  this.huespedDAO.buscarIdReservaHuesped(id, id_r);
	}
}
