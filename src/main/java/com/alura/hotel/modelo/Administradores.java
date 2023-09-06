package com.alura.hotel.modelo;

/**
 * @version 1.0
 * @author Dainer Cortes
 */
public class Administradores {

	private String usuario;
	private String contraseña;

	/**
	 * Metodo constructor
	 * @param usuario
	 * @param contraseña
	 */
	public Administradores(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	/**
	 * Retorna el nombre de usuario
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Retorna la contraseña del usuario
	 * @return
	 */
	public String getContraseña() {
		return contraseña;
	}
}
