package com.alura.hotel.modelo;

import java.sql.Date;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class Huespedes {

	private Integer id;
	private String nombre;
	private String apellido;
	private Date fecha_nacimiento;
	private Integer id_nacionalidad;
	private String nombre_nacionalidad;
	private String telefono;
	private Integer id_reserva;

	/**
	 * Constructor vacio
	 */
	public Huespedes() {

	}

	/**
	 * Constructor sobrecargado
	 *
	 * @param nombre
	 * @param apellido
	 * @param fecha_nacimiento
	 * @param telefono
	 */
	public Huespedes(String nombre, String apellido, Date fecha_nacimiento, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
	}

	/**
	 * Constructor sobrcargado
	 *
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param fecha_nacimiento
	 * @param id_nacionalidad
	 * @param telefono
	 * @param id_reserva
	 */
	public Huespedes(Integer id, String nombre, String apellido, Date fecha_nacimiento, Integer id_nacionalidad,
					 String telefono, Integer id_reserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.id_nacionalidad = id_nacionalidad;
		this.telefono = telefono;
		this.id_reserva = id_reserva;
	}
	
	public Huespedes(Integer id, String nombre, String apellido, Date fecha_nacimiento, String nacionalidad,
			 String telefono, Integer id_reserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nombre_nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.id_reserva = id_reserva;
	}

	/**
	 * Devuelve el id del huesped
	 *
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Guarda el id del huesped
	 *
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre del huesped
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Guarda el nombre del huesped
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el apellido del huesped
	 *
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Guarda el apellido del huesped
	 *
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve la fecha de nacimiento del huesped
	 *
	 * @return
	 */
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	/**
	 * Guarda la fecha de nacimiento del huesped
	 *
	 * @param fecha_nacimiento
	 */
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	/**
	 * Devuelve el id nacionalidad del huesped
	 *
	 * @return
	 */
	public Integer getId_nacionalidad() {
		return id_nacionalidad;
	}

	/**
	 * Guarda el id nacionalidad del huesped
	 *
	 * @param id_nacionalidad
	 */
	public void setId_nacionalidad(Integer id_nacionalidad) {
		this.id_nacionalidad = id_nacionalidad;
	}

	/**
	 * Devuelve la nacionalidad del huesped
	 *
	 * @return
	 */
	public String getNombre_Nacionalidad() {
		return nombre_nacionalidad;
	}

	/**
	 * Devuelve el numero de telefono del cliente
	 *
	 * @return
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Guarda el numero de telefono del huesped
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Devuelve el id de reserva del huesped
	 * @return
	 */
	public Integer getId_reserva() {
		return id_reserva;
	}

	/**
	 * Guarda el id de reserva del huesped
	 * @param id_reserva
	 */
	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}
}
