package com.alura.hotel.controller;

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
	
	public int eliminar() {
		return 0;
	}
	
	public int modificar() {
		return 0;
	}
	
	public List<Reservas> listar() {
		return reservasDao.listar();
	}

}
