package com.alura.hotel.controller;

import com.alura.hotel.dao.AdministradoresDAO;
import com.alura.hotel.factory.ConnectionFactory;

/**
 * @version 1.0
 * @author Dainer Cortes
 */
public class AdministradoresController {

	private AdministradoresDAO administradoresDAO;

	/**
	 * Metodo constructor
	 * Llama la conexión de la DB
	 */
	public AdministradoresController() {

		var factory = new ConnectionFactory();
		this.administradoresDAO = new AdministradoresDAO(factory.recuperarConexion());
	}

	/**
	 * Metodo para verificar el login en el sistema
	 *
	 * @param usuario
	 * @param contraseña
	 * @return
	 */
	public Boolean verificar(String usuario, String contraseña) {
		return this.administradoresDAO.verificarLogin(usuario, contraseña);
	}
}
