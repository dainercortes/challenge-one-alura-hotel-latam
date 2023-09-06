package com.alura.hotel.controller;

import java.sql.Date;
import java.util.List;

import com.alura.hotel.dao.ReservasDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservas;

public class ReservasController {
	
	private ReservasDAO reservasDao;
	
	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservasDao = new ReservasDAO(factory.recuperarConexion());
	}
	
	public void guardar(Reservas reserva) {
		reservasDao.guardar(reserva);
	}
	
	public List<Reservas> listar() {
		return reservasDao.listar();
	}

	public List<Reservas> listarPorId(Integer idReserva) {
		// TODO Auto-generated method stub
		return reservasDao.listarPorId(idReserva);
	}

	public int eliminar(Integer id) {
		return reservasDao.eliminar(id);
	}

	public int modificar(Integer id, Date fecha_entrada, Date fecha_salida, String forma_pago, Float valor) {
		return reservasDao.modificar(id, fecha_entrada, fecha_salida, forma_pago, valor);
		
	}
	public int buscarIdReserva(Integer id) {
		return this.reservasDao.buscarIdReserva(id);
	}
}
