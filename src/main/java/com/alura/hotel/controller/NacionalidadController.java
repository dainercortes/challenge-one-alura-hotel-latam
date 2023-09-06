package com.alura.hotel.controller;

import java.util.List;

import com.alura.hotel.dao.NacionalidadDAO;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Nacionalidad;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class NacionalidadController {

	private NacionalidadDAO nacionalidadDAO;

	/**
	 * Metodo constructor,
	 * Llama la conexion de la DB
	 */
	public NacionalidadController() {
		
		var factory = new ConnectionFactory();
		this.nacionalidadDAO = new NacionalidadDAO(factory.recuperarConexion());
	}

	/**
	 * Metodo que devuelve la lista de nacionalidades
	 *
	 * @return
	 */
	public List<Nacionalidad> listar() {
		return this.nacionalidadDAO.listar();
	}

	/**
	 * Metodo que busca una nacionalidad por el nombre
	 * Ejemplo: Busca Colombniano
	 *
	 * @param nombre
	 * @return
	 */
	public int buscarPorNombre(String nombre) {
		return this.nacionalidadDAO.buscarPorNombre(nombre);
	}
}
