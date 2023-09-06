package com.alura.hotel.controller;

import java.sql.Date;
import java.util.List;

import com.alura.hotel.dao.ReservasDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservas;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class ReservasController {
	
	private ReservasDAO reservasDao;

	/**
	 * Metodo constructor,
	 * Llama la conexion de la DB
	 */
	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservasDao = new ReservasDAO(factory.recuperarConexion());
	}

	/**
	 * Metodo para guardar la reserva en la DB
	 *
	 * @param reserva
	 */
	public void guardar(Reservas reserva) { reservasDao.guardar(reserva); }

	/**
	 * Metodo que devuelve la lista de reservas
	 *
	 * @return
	 */
	public List<Reservas> listar() {
		return reservasDao.listar();
	}

	/**
	 * Metodo que devuelve la reserva buscandola por id
	 * @param idReserva
	 * @return
	 */
	public List<Reservas> listarPorId(Integer idReserva) {
		return reservasDao.listarPorId(idReserva);
	}

	/**
	 * Metod que elimina una reserva
	 *
	 * @param id
	 * @return
	 */
	public int eliminar(Integer id) {
		return reservasDao.eliminar(id);
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
		return reservasDao.modificar(id, fecha_entrada, fecha_salida, forma_pago, valor);
		
	}

	/**
	 * Metodo que verifica si existe una reserva en la DB
	 * @param id
	 * @return
	 */
	public int buscarIdReserva(Integer id) {
		return this.reservasDao.buscarIdReserva(id);
	}
}
