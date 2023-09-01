package com.alura.hotel.controller;

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

}
