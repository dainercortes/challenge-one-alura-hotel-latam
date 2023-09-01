package com.alura.hotel.controller;

import com.alura.hotel.dao.AdministradoresDAO;
import com.alura.hotel.factory.ConnectionFactory;

public class AdministradoresController {

	private AdministradoresDAO administradoresDAO;
	
	public AdministradoresController() {

		var factory = new ConnectionFactory();
		this.administradoresDAO = new AdministradoresDAO(factory.recuperarConexion());
	}
	
	public Boolean verificar(String usuario, String contraseña) {
		return this.administradoresDAO.verificarLogin(usuario, contraseña);
	}
}
