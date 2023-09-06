package com.alura.hotel.controller;

import java.sql.Date;
import java.util.List;

import com.alura.hotel.dao.HuespedesDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huespedes;

public class HuespedesController {
	
	private HuespedesDAO huespedDAO;
	
	public HuespedesController() {
		var factory = new ConnectionFactory();
		this.huespedDAO = new HuespedesDAO(factory.recuperarConexion());
	}
	
	public void guardar(Huespedes huesped, Integer id_nacionalidad, Integer id_reserva) {
		huesped.setId_nacionalidad(id_nacionalidad);
		huesped.setId_reserva(id_reserva);
		huespedDAO.guardar(huesped);
	}
	
	public List<Huespedes> listar() {
		return huespedDAO.listar();
	}
	
	public List<Huespedes> listarPorApellido(String apellido) {
		return huespedDAO.listarPorApellido(apellido);
	}

	public int eliminar(Integer id) {
		return huespedDAO.eliminar(id);
	}

	public int eliminarConReserva(Integer id_reserva) {
		return huespedDAO.eliminarConReserva(id_reserva);
	}

	public int modificar(Integer id, String nombre, String apellido, Date fechaNacimiento, Integer nacionalidad, String telefono, Integer numReserva) {
		return huespedDAO.modificar(id, nombre, apellido, fechaNacimiento, nacionalidad, telefono, numReserva);
	}

	public int buscarIdReservaHuesped(Integer id, Integer id_r) {
		return  this.huespedDAO.buscarIdReservaHuesped(id, id_r);
	}
}
