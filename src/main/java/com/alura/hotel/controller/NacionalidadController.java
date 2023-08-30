package com.alura.hotel.controller;

import java.util.List;

import com.alura.hotel.dao.NacionalidadDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Nacionalidad;

public class NacionalidadController {

	private NacionalidadDAO nacionalidadDAO;
	
	public NacionalidadController() {
		
		var factory = new ConnectionFactory();
		this.nacionalidadDAO = new NacionalidadDAO(factory.recuperarConexion());
	}
	public List<Nacionalidad> listar() {
		return this.nacionalidadDAO.listar();
	}
//	public List<Nacionalidad> cargarReporte() {
//		return this.nacionalidadDAO.listarConHuespedes();
//	}
}
