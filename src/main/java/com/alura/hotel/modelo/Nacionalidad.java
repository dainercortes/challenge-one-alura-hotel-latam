package com.alura.hotel.modelo;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class Nacionalidad {
	private Integer id;
	private String nombre;
	
	//private List<>

	/**
	 * Metodo constructor
	 *
	 * @param id
	 * @param nombre
	 */
	public Nacionalidad(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Retorna el id de la nacionalidad
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Retorna el nombre de la nacionalidad
	 * @return
	 */
	@Override
	public String toString() {
		return this.nombre;
	}
}
