package com.alura.hotel.modelo;

import java.sql.Date;

public class Huespedes {

	private Integer id;
	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private Integer id_nacionalidad;
	private String telefono;
	private Integer id_reserva;
	
	public Huespedes(String nombre, String apellido, Date fecha_nacimiento, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Integer getId_nacionalidad() {
		return id_nacionalidad;
	}

	public void setId_nacionalidad(Integer id_nacionalidad) {
		this.id_nacionalidad = id_nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}
}
