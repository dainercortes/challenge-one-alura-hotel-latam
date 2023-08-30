package com.alura.hotel.modelo;

public class Nacionalidad {
	private Integer id;
	private String nombre;
	
	//private List<>
	
	public Nacionalidad(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
