package com.alura.hotel.modelo;

public class Administradores {

	private String usuario;
	private String contraseña;
	
	public Administradores(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContraseña() {
		return contraseña;
	}
}
